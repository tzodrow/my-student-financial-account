/**
 * 
 */
package edu.wisc.student.finance.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.function.Predicate;

import org.junit.Test;

import edu.wisc.student.finance.v1.ChargeType;

/**
 * Tests for {@link DemoChargeDaoImpl}.
 * 
 * @author Nicholas Blair
 */
public class DemoChargeDaoImplTest {

  /**
   * Confirm properly initialized {@link DemoChargeDaoImpl} has expected data.
   * 
   * @throws IOException 
   */
  @Test
  public void getCharges_control() throws IOException {
    DemoChargeDaoImpl service = new DemoChargeDaoImpl();
    service.init();
    
    Collection<ChargeType> charges = service.getCharges("bbadger");
    assertEquals(3, charges.size());
    for(ChargeType charge: charges) {
      if("1".equals(charge.getId())) {
        assertEquals("Tuition", charge.getName());
        assertEquals("Fall 2016 Tuition Charges", charge.getDescription());
        assertTrue(new BigDecimal("6000.00").compareTo(charge.getBalanceDue()) == 0);
      } else if("2".equals(charge.getId())) {
        assertEquals("Housing", charge.getName());
        assertEquals("117 Bleyer Bradley - Double Room (10/25/14-12/20/14)", charge.getDescription());
        assertTrue(new BigDecimal("3500.00").compareTo(charge.getBalanceDue()) == 0);
      } else if("3".equals(charge.getId())) {
        assertEquals("Health Services", charge.getName());
        assertEquals("", charge.getDescription());
        assertTrue(new BigDecimal("24.00").compareTo(charge.getBalanceDue()) == 0);
      }
    }
  }
  
  
	/**
	 * This test verifies that all demo users have a balance due.
	 * Its not a good test but it serves as proof that we can use java 8.
	 * @throws IOException
	 */
	@Test
  public void AllDemoUsersHaveBalanceDue() throws IOException {
	  DemoChargeDaoImpl service = new DemoChargeDaoImpl();
	   service.init();
	   boolean allMatch = service.getCharges("bbadger").stream().allMatch( 
			   (p)-> p.getBalanceDue().compareTo(new BigDecimal(0)) != 0
			  );
	   assertTrue(allMatch);
  }
}


