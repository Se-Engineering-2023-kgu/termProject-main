/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain ;

import java.sql.Date ;
import java.sql.Time ;

/* This needs to be an interface so that PersistentBooking can be
   an interface, and so implemented by PersistentReservation and
   PersistentWalkin which already extend Reservation and Walkin.
*/

public interface Booking
{
  Time  getArrivalTime() ;
  int   getCovers() ;
  Date  getDate() ;
  Time  getEndTime() ;
  Time  getTime() ;
  Table getTable() ;
  int   getTableNumber() ;
  
  String getDetails() ;
  
  void setArrivalTime(Time t) ;
  void setCovers(int c) ;
  void setDate(Date d) ;
  void setTime(Time t) ;
  void setTable(Table t) ;
}
