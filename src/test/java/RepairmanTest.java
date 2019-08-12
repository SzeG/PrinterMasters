/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.printermasters.Repairman;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mi
 */
public class RepairmanTest {

    public RepairmanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    // public void hello() {}
    @Test
    public void CreateTest() {
        Repairman r = new Repairman(new ImmutablePair(2, 1), 200, 100, "Neve");
        assertEquals("Not correct name ", "Neve", r.getName());
        if (r.getX() != 2) {
            fail("Incorrect  X coordinate ");
        }
        if (r.getY() != 1) {
            fail("Incorrect Y coordinate ");
        }
        if (r.getBaseFee() != 200) {
            fail("Incorrect base fee");
        }
        if (r.getTravelFee() != 100) {
            fail("Incorrect travel fee");
        }
    }
    @Test
    public void DeafaultNameTest(){
    Repairman r = new Repairman(new ImmutablePair(2, 1), 200, 100, null);
        assertEquals("Incorrext default name", "Rep_21",r.getName());
}
    @Test
    public void DefaultBaseFeeTest(){
      Repairman r = new Repairman(new ImmutablePair(2, 1), null, 100, "Rep");
      if(r.getBaseFee()!=Repairman.defaultBaseFee)fail("Incorrect default base fee");
    }

}
