/**
 * 
 */
package edu.wisc.student.finance.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;

import edu.wisc.student.finance.v1.ChargeType;

/**
 * Tests for {@link DemoChargeServiceImpl}.
 * 
 * @author Nicholas Blair
 */
public class DemoChargeServiceImplTest {

  /**
   * Confirm properly initialized {@link DemoChargeServiceImpl} has expected data.
   * 
   * @throws IOException 
   */
  @Test
  public void getCharges_control() throws IOException {
    DemoChargeServiceImpl service = new DemoChargeServiceImpl();
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
}
