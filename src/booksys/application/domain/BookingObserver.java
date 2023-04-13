/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain ;

public interface BookingObserver
{
  void update() ;

  boolean message(String s, boolean confirm) ;
}
