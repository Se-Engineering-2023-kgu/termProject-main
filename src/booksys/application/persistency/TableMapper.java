/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.persistency ;

import booksys.storage.Database ;

import java.sql.* ;
import java.util.Enumeration ;
import java.util.Hashtable ;
import java.util.Vector ;

public class TableMapper
{
  // Implementation of hidden cache
  
  private final Hashtable cache ;

  private PersistentTable getFromCache(int oid)
  {
    Integer key = Integer.valueOf(oid);
    return (PersistentTable) cache.get(key) ;
  }

  private PersistentTable getFromCacheByNumber(int tno)
  {
    PersistentTable t = null ;
    Enumeration<?> table = cache.elements() ;
    while (t == null & table.hasMoreElements()) {
      PersistentTable tmp = (PersistentTable) table.nextElement() ;
      if (tmp.getNumber() == tno) {
	t = tmp ;
      }
    }
    return t ;
  }
  
  private void addToCache(PersistentTable t)
  {
    Integer key = Integer.valueOf(t.getId());
    cache.put(key, t) ;
  }
  
  // Constructor:
  
  private TableMapper()
  {
    cache = new Hashtable() ;
  }

  // Singleton:
  
  private static TableMapper uniqueInstance ;

  public static TableMapper getInstance()
  {
    if (uniqueInstance == null) {
      uniqueInstance = new TableMapper() ;
    }
    return uniqueInstance ;
  }

  public PersistentTable getTable(int tno)
  {
    PersistentTable t = getFromCacheByNumber(tno) ;
    if (t == null) {
      t = getTable("SELECT * FROM `Table` WHERE number='" + tno + "'") ;
      if (t != null) {
	addToCache(t) ;
      }
    }
    return t ;
  }

  PersistentTable getTableForOid(int oid)
  {
    PersistentTable t = getFromCache(oid) ;
    if (t == null) {
      t = getTable("SELECT * FROM `Table` WHERE oid ='" + oid + "'") ;
      if (t != null) {
	addToCache(t) ;
      }
    }
    return t ;
  }

  private PersistentTable getTable(String sql)
  {
    PersistentTable t = null ;
    try {
      Statement stmt
	= Database.getInstance().getConnection().createStatement() ;
      ResultSet rset = stmt.executeQuery(sql) ;
      while (rset.next()) {
	int oid    = rset.getInt(1) ;
	int number = rset.getInt(2) ;
	int places = rset.getInt(3) ;
	t = new PersistentTable(oid, number, places) ;
      }
      rset.close() ;
      stmt.close() ;
    }
    catch (SQLException e) {
      e.printStackTrace() ;
    }
    return t ;
  }

  public Vector getTableNumbers()
  {
    Vector v = new Vector() ;
    try {
      Statement stmt
	= Database.getInstance().getConnection().createStatement() ;
      ResultSet rset
	= stmt.executeQuery("SELECT * FROM `Table` ORDER BY number") ;
      while (rset.next()) {
	v.addElement(Integer.valueOf(rset.getInt(2))) ;
      }
      rset.close() ;
      stmt.close() ;
    }
    catch (SQLException e) {
      e.printStackTrace() ;
    }
    return v ;
  }    
  
}
