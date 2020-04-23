package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.BookingDetailDAO;
import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.service.BookingService;
import com.chainsys.busticketapp.service.OperatorsService;
import com.chainsys.busticketapp.service.SeatService;
import com.chainsys.busticketapp.util.DbConnection;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.dto.Users;

@Repository

public class BookingDetailDAOImpl implements BookingDetailDAO {
	private static final Logger logger = LoggerFactory.getLogger(BookingDetailDAOImpl.class);

	public int findbyBookedDateAndBusNumber(LocalDate bookedDate, int busNum) throws DbException {
		int seats = 0;
		String sql = " select max(seat_no) as seat_no from booking where booked_date=? and bus_num= ?";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setDate(1, Date.valueOf(bookedDate));
			pst.setInt(2, busNum);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					seats = rs.getInt("seat_no");
				}
			}
		} catch (SQLException e) {
			throw new DbException("unable to find seats", e);
		}
		return seats;
	}

	public Booking findbyBookedDateAndBusNumberAndSeatNo(LocalDate bookedDate, int BusNum, int seatNo)
			throws DbException {
		String sql = " select seat_no, user_gender,gender_preferences from booking where booked_date=? and bus_num= ? and seat_no =?";
		Booking booking = null;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setDate(1, Date.valueOf(bookedDate));
			pst.setInt(2, BusNum);
			pst.setInt(3, seatNo);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					booking = new Booking();
					booking.setSeatNo(rs.getInt("seat_no"));
					booking.setUserGender(rs.getString("user_gender"));
					booking.setGenderPreference(rs.getString("gender_preferences"));
				}
			}
		} catch (SQLException e) {
			throw new DbException("unable to find seat number,gender,gender_preference", e);
		}
		return booking;
	}

	public HashMap<Integer, String> findByBusNumber(int busNum) throws DbException {

		String sql = "select seat_no,user_gender from booking where bus_num=?";
		HashMap<Integer, String> m = new HashMap<Integer, String>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, busNum);

			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					int seatNo = rs.getInt("seat_no");
					String gender = rs.getString("user_gender");
					m.put(seatNo, gender);
				}
			}
		} catch (SQLException e) {
			throw new DbException("unable to find seat number,gender", e);
		}
		return m;
	}

	public int addUserBookingDetails(Booking booking) throws DbException {

		SeatService ss = new SeatService();
		int nextSeatNo = ss.getNextSeatNo(booking.getBookedDate(), booking.getBusNum());
		booking.setSeatNo(nextSeatNo);
		int nextSeatNo1 = ss.getNextSeatNo(booking.getBookedDate(), booking.getBusNum(), booking.getUserGender(),
				booking.getGenderPreference());
		booking.setSeatNo(nextSeatNo1);
		int rows = 0;

		String sql1 = "select no_of_seats from buslist where bus_num=?";
		String str = "insert into booking(booking_id,user_id,bus_num,user_gender,seat_no,booked_date,gender_preferences,amount) values(booked_id.nextval,?,?,?,?,?,?,?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst1 = connection.prepareStatement(sql1);
				PreparedStatement pst = connection.prepareStatement(str);) {
			pst1.setInt(1, booking.getBusNum());
			int totalSeats = 0;
			try (ResultSet rs = pst1.executeQuery();) {
				if (rs.next()) {
					totalSeats = rs.getInt("no_of_seats");
				}
				boolean isSeatsAvailable = totalSeats >= booking.getSeatNo();
				System.out.println("SeatsAvailable:" + isSeatsAvailable + ",totalSeats=" + totalSeats
						+ ",booking Seat NO:" + booking.getSeatNo());
				if (isSeatsAvailable) {
					pst.setInt(1, booking.getUserId());
					pst.setInt(2, booking.getBusNum());
					pst.setString(3, booking.getUserGender());
					pst.setInt(4, booking.getSeatNo());
					pst.setDate(5, Date.valueOf(booking.getBookedDate()));
					pst.setString(6, booking.getGenderPreference());
					pst.setInt(7, booking.getAmount());
					if (booking.getSeatNo() != 0) {
						rows = pst.executeUpdate();
						System.out.println(rows);
					} else
						System.out.println("seats are not available");
				}
			}
		} catch (SQLException e) {
			throw new DbException("unable to add data", e);
		}
		return (rows);
	}

	public int save(Booking booking, int seatNo) throws DbException {
		String str = "insert into booking(booking_id,user_id,bus_num,user_gender,seat_no,booked_date,gender_preferences,amount) values(booked_id.nextval,?,?,?,?,?,?,?)";
		int flag = 0;
		HashMap<String, String> hm = new HashMap<String, String>();
		SeatDAOImpl si = new SeatDAOImpl();
		String gender = null;
		String gender_preference = null;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(str);) {
			hm = si.findSeatsByBookedDateAndBusNumberAndSeatNumber(booking.getBusNum(), seatNo,
					booking.getBookedDate());
			for (String s : hm.keySet()) {
				gender = s;
				gender_preference = hm.get(s);
			}
			System.out.println(gender + "  " + gender_preference);
			pst.setInt(1, booking.getUserId());
			pst.setInt(2, booking.getBusNum());
			pst.setString(3, booking.getUserGender());
			pst.setInt(4, seatNo);
			pst.setDate(5, Date.valueOf(booking.getBookedDate()));
			pst.setString(6, booking.getGenderPreference());
			pst.setInt(7, booking.getAmount());
			if (booking.getUserGender().equals(gender) && booking.getGenderPreference().equals(gender_preference)) {
				int rows = pst.executeUpdate();
				System.out.println("seats are available");
				if (rows == 1) {
					flag = 1;
				}
			} else if (booking.getUserGender().equals(gender)
					&& (!booking.getGenderPreference().equals(gender_preference))) {
				int rows = pst.executeUpdate();
				if (rows == 1) {
					flag = 1;
				}
				System.out.println("seats are available");
			} else if (!booking.getUserGender().equals(gender)
					&& (booking.getGenderPreference().equals("no") && gender_preference.equals("no"))) {
				int rows = pst.executeUpdate();
				if (rows == 1) {
					flag = 1;
				}
				System.out.println("seats are available");
			} else {
				System.out.println("seats are not available");
			}
		} catch (SQLException e) {
			throw new DbException("unable to add data", e);
		}
		return (flag);
	}

	public int bookUnfilledSeats(Booking booking) throws DbException {
		SeatDAOImpl sdi = new SeatDAOImpl();
		int res = 0;
		ArrayList<Integer> ai = new ArrayList<Integer>();
		ai = sdi.findUnFilledSeatsByBusNumberAndBookedDate(booking.getBookedDate(), booking.getBusNum());
		System.out.println("***Un filled seats***\n");
		for (int seat : ai) {
			res = save(booking, seat);
			if (res == 1)
				break;
		}
		return (res);
	}

	@Override
	public void update(String bookingId) throws DbException {
		String sql = "update booking set status='CANCELLED' where booking_id = ?";
		logger.info("Update : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, bookingId);
			int rows = pst.executeUpdate();
			System.out.println(rows);
		} catch (SQLException e) {
			throw new DbException("unable to update status", e);
		}
	}

	public int save(Booking booking) throws DbException {
		String str = "insert into booking(booking_id,user_id,bus_num,user_gender,seat_no,booked_date,gender_preferences,amount) values(booked_id.nextval,?,?,?,?,?,?,?)";
		logger.info("Booking : " + str);
		int rows = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(str);) {
			pst.setInt(1, booking.getUserId());
			pst.setInt(2, booking.getBusNum());
			pst.setString(3, booking.getUserGender());
			pst.setInt(4, booking.getSeatNo());
			pst.setDate(5, Date.valueOf(booking.getBookedDate()));
			pst.setString(6, booking.getGenderPreference());
			pst.setInt(7, booking.getAmount());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException("unable to add", e);
		}
		return (rows);
	}

	public int findPriceByBusNumber(int busNum) throws DbException {
		String sql = "Select fair from busdetails where bus_num=?";
		logger.info("Fare : " + sql);
		int price = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, busNum);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					price = rs.getInt("fair");
				}
			}
		} catch (SQLException e) {
			throw new DbException("unable to find fare", e);
		}
		return price;
	}

	public String findUserGender(LocalDate bookedDate, String status, int busNum) throws Exception {
		String g = null;
		String sql = "select user_gender from booking where booked_date=? and status=? and bus_num=?";
		logger.info("Booking : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setDate(1, Date.valueOf(bookedDate));
			pst.setString(2, status);
			pst.setInt(3, busNum);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					g = (rs.getString("user_gender"));
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND DATA", e);
		}
		return g;
	}
	public static void main(String[] args) throws Exception {
		BookingDetailDAOImpl t = new BookingDetailDAOImpl();
		//String user = t.findUserGender(LocalDate.parse("2020-03-28"), "BOOKED", 8);
		//System.out.println(user);
		/*BookingService bs= new BookingService();
		Booking b=new Booking();

	int s=bs.addBooking(b);
		System.out.println(s);
int a = bs.getPrice(1);
System.out.println(a);*/

OperatorsService os= new OperatorsService();
		/*List<OperatorsDetails> list1 = os.findOperator();
		System.out.println(list1);
		OperatorsDetailsDAOImpl o = new OperatorsDetailsDAOImpl();
		List<Buses> list=new ArrayList<Buses>();
		list=o.findAllByOperatorName("TAT Travels");
		System.out.println("hi");
		System.out.println(list);
		for(Buses buses:list)
		{
			
			System.out.println(buses);
		}*/
		
		/*List<Buses> list=new ArrayList<Buses>();
		list=os.findByOperatorName("TAT Travels");
		System.out.println("hi");
		System.out.println(list);
		for(Buses buses:list)
		{
			
			System.out.println(buses);
		}*/
		OperatorsDetailsDAOImpl s = new OperatorsDetailsDAOImpl();
		//List<Buses> list=new ArrayList<Buses>();
           /*list=s.findOperatorNames(1);
	System.out.println(list);*/
	//int a=s.findOperatorIdByOperatorMailIdAndPassword("tat@gmail.com","tat1234");
	//System.out.println(a);
	//List<Buses> list=new ArrayList<Buses>();

	//List<Buses> b=s.findOperatorName(1);
	//System.out.println(b);
 UserDetailsDAOImpl us= new UserDetailsDAOImpl();
	List<Users> list = new ArrayList<Users>();
	list=us.findUserDetails("BOOKED", LocalDate.parse("2020-04-13"), 11);
	System.out.println("test:"+list);
		
	}	
}
