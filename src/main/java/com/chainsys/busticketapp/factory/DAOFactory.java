package com.chainsys.busticketapp.factory;

import com.chainsys.busticketapp.dao.AdminDAO;
import com.chainsys.busticketapp.dao.BookingDetailDAO;
import com.chainsys.busticketapp.dao.BusDetailsDAO;
import com.chainsys.busticketapp.dao.BusDAO;
import com.chainsys.busticketapp.dao.BusRoutesDAO;
import com.chainsys.busticketapp.dao.OperatorsDetailsDAO;
import com.chainsys.busticketapp.dao.TicketBookingDAO;
import com.chainsys.busticketapp.dao.UserDetailsDAO;
import com.chainsys.busticketapp.dao.impl.AdminDAOImpl;
import com.chainsys.busticketapp.dao.impl.BookingDetailDAOImpl;
import com.chainsys.busticketapp.dao.impl.BusDetailsDAOImpl;
import com.chainsys.busticketapp.dao.impl.BusDAOImpl;
import com.chainsys.busticketapp.dao.impl.BusRoutesDAOImpl;
import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.dao.impl.TicketBookingDAOImpl;
import com.chainsys.busticketapp.dao.impl.UserDetailsDAOImpl;

public class DAOFactory {
	public static BusDAO getBusListDAO()
	{
	return new BusDAOImpl();
	}
	public static AdminDAO getAdminDAO()
	{
	return new AdminDAOImpl();
	}
	public static BookingDetailDAO getBookingDeatilsDAO()
	{
	return new BookingDetailDAOImpl();
	}
	public static BusDetailsDAO getBusDetailsDAO()
	{
	return new  BusDetailsDAOImpl();
	}
	public static BusRoutesDAO getBusRoutesDAO()
	{
	return new  BusRoutesDAOImpl();
	}
	public static OperatorsDetailsDAO getOperatorsDetailsDAO()
	{
	return new  OperatorsDetailsDAOImpl();
	}
	public static TicketBookingDAO getTicketBookingDAO()
	{
	return new  TicketBookingDAOImpl();
	}
	public static UserDetailsDAO getUserDetailsDAO()
	{
	return new  UserDetailsDAOImpl();
	}
}
