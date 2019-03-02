import java.util.Comparator;

import edu.uwm.cs351.Sequence;

import junit.framework.TestCase;

public class TestExhaustive extends TestCase {
  private Comparator<Integer> comp = (a,b) -> a - b;
  private Sequence<Integer> ss;
  @Override
  protected void setUp() {
    ss = new Sequence<>();
  }
  
  // additional test case provided on course website
  public void test0000() {
      ss.sort(comp);
      assertEquals(0,ss.size());
  }

  public void test1001() {
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
  }

  public void test2001() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
  }

  public void test2002() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
  }

  public void test3001() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
  }

  public void test3002() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
  }

  public void test3003() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
  }

  public void test3004() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
  }

  public void test3005() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
  }

  public void test3006() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4001() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4002() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4003() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4004() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4005() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4006() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4007() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4008() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4009() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4010() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4011() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4012() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4013() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4014() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4015() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4016() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4017() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4018() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4019() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4020() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4021() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4022() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4023() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test4024() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5001() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5002() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5003() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5004() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5005() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5006() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5007() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5008() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5009() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5010() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5011() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5012() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5013() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5014() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5015() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5016() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5017() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5018() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5019() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5020() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5021() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5022() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5023() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5024() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5025() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5026() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5027() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5028() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5029() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5030() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5031() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5032() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5033() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5034() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5035() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5036() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5037() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5038() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5039() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5040() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5041() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5042() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5043() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5044() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5045() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5046() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5047() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5048() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5049() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5050() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5051() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5052() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5053() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5054() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5055() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5056() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5057() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5058() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5059() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5060() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5061() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5062() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5063() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5064() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5065() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5066() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5067() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5068() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5069() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5070() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5071() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5072() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5073() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5074() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5075() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5076() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5077() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5078() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5079() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5080() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5081() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5082() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5083() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5084() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5085() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5086() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5087() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5088() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5089() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5090() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5091() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5092() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5093() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5094() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5095() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5096() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5097() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5098() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5099() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5100() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5101() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5102() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5103() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5104() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5105() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5106() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5107() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5108() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5109() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5110() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5111() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5112() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5113() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5114() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5115() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5116() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5117() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5118() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5119() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test5120() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6001() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6002() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6003() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6004() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6005() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6006() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6007() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6008() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6009() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6010() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6011() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6012() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6013() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6014() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6015() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6016() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6017() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6018() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6019() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6020() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6021() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6022() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6023() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6024() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6025() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6026() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6027() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6028() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6029() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6030() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6031() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6032() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6033() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6034() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6035() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6036() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6037() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6038() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6039() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6040() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6041() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6042() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6043() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6044() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6045() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6046() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6047() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6048() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6049() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6050() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6051() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6052() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6053() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6054() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6055() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6056() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6057() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6058() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6059() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6060() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6061() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6062() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6063() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6064() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6065() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6066() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6067() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6068() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6069() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6070() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6071() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6072() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6073() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6074() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6075() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6076() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6077() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6078() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6079() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6080() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6081() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6082() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6083() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6084() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6085() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6086() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6087() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6088() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6089() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6090() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6091() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6092() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6093() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6094() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6095() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6096() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6097() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6098() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6099() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6100() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6101() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6102() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6103() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6104() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6105() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6106() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6107() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6108() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6109() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6110() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6111() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6112() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6113() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6114() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6115() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6116() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6117() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6118() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6119() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6120() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6121() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6122() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6123() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6124() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6125() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6126() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6127() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6128() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6129() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6130() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6131() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6132() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6133() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6134() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6135() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6136() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6137() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6138() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6139() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6140() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6141() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6142() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6143() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6144() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6145() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6146() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6147() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6148() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6149() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6150() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6151() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6152() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6153() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6154() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6155() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6156() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6157() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6158() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6159() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6160() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6161() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6162() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6163() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6164() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6165() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6166() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6167() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6168() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6169() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6170() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6171() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6172() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6173() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6174() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6175() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6176() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6177() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6178() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6179() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6180() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6181() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6182() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6183() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6184() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6185() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6186() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6187() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6188() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6189() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6190() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6191() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6192() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6193() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6194() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6195() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6196() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6197() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6198() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6199() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6200() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6201() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6202() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6203() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6204() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6205() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6206() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6207() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6208() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6209() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6210() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6211() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6212() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6213() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6214() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6215() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6216() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6217() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6218() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6219() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6220() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6221() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6222() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6223() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6224() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6225() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6226() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6227() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6228() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6229() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6230() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6231() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6232() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6233() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6234() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6235() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6236() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6237() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6238() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6239() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6240() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6241() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6242() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6243() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6244() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6245() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6246() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6247() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6248() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6249() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6250() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6251() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6252() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6253() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6254() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6255() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6256() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6257() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6258() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6259() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6260() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6261() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6262() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6263() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6264() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6265() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6266() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6267() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6268() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6269() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6270() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6271() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6272() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6273() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6274() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6275() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6276() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6277() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6278() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6279() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6280() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6281() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6282() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6283() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6284() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6285() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6286() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6287() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6288() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6289() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6290() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6291() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6292() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6293() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6294() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6295() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6296() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6297() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6298() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6299() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6300() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6301() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6302() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6303() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6304() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6305() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6306() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6307() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6308() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6309() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6310() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6311() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6312() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6313() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6314() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6315() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6316() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6317() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6318() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6319() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6320() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6321() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6322() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6323() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6324() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6325() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6326() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6327() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6328() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6329() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6330() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6331() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6332() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6333() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6334() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6335() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6336() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6337() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6338() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6339() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6340() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6341() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6342() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6343() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6344() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6345() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6346() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6347() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6348() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6349() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6350() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6351() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6352() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6353() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6354() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6355() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6356() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6357() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6358() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6359() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6360() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6361() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6362() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6363() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6364() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6365() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6366() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6367() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6368() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6369() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6370() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6371() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6372() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6373() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6374() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6375() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6376() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6377() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6378() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6379() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6380() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6381() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6382() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6383() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6384() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6385() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6386() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6387() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6388() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6389() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6390() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6391() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6392() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6393() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6394() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6395() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6396() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6397() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6398() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6399() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6400() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6401() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6402() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6403() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6404() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6405() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6406() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6407() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6408() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6409() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6410() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6411() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6412() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6413() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6414() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6415() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6416() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6417() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6418() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6419() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6420() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6421() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6422() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6423() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6424() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6425() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6426() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6427() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6428() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6429() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6430() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6431() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6432() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6433() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6434() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6435() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6436() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6437() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6438() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6439() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6440() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6441() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6442() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6443() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6444() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6445() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6446() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6447() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6448() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6449() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6450() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6451() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6452() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6453() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6454() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6455() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6456() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6457() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6458() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6459() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6460() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6461() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6462() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6463() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6464() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6465() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6466() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6467() {
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6468() {
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6469() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6470() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6471() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6472() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6473() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6474() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6475() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6476() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6477() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6478() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6479() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6480() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6481() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6482() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6483() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6484() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6485() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6486() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6487() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6488() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6489() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6490() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6491() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6492() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6493() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6494() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6495() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6496() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6497() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6498() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6499() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6500() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6501() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6502() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6503() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6504() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6505() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6506() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6507() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6508() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6509() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6510() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6511() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6512() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6513() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6514() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6515() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6516() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6517() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6518() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6519() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6520() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6521() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6522() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6523() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6524() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6525() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6526() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6527() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6528() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6529() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6530() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6531() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6532() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6533() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6534() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6535() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6536() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6537() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6538() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6539() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6540() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6541() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6542() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6543() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6544() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6545() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6546() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6547() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6548() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6549() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6550() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6551() {
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6552() {
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6553() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6554() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6555() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6556() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6557() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6558() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6559() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6560() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6561() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6562() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6563() {
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6564() {
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6565() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6566() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6567() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6568() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6569() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6570() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6571() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6572() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6573() {
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6574() {
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6575() {
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6576() {
    ss.addAfter(1);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6577() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6578() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6579() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6580() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6581() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6582() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6583() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6584() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6585() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6586() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6587() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6588() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6589() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6590() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6591() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6592() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6593() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6594() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6595() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6596() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6597() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6598() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6599() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6600() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.addAfter(4);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6601() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6602() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6603() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6604() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6605() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6606() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6607() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6608() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6609() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6610() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6611() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6612() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6613() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6614() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6615() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6616() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6617() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6618() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6619() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6620() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6621() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6622() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6623() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6624() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6625() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6626() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6627() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6628() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6629() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6630() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6631() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6632() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6633() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6634() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6635() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6636() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6637() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6638() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6639() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6640() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6641() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6642() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6643() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6644() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6645() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6646() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6647() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6648() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6649() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6650() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6651() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6652() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6653() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6654() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6655() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6656() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6657() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6658() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6659() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6660() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6661() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6662() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6663() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6664() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6665() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6666() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6667() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6668() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6669() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6670() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6671() {
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6672() {
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6673() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6674() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6675() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6676() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6677() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6678() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6679() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6680() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6681() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6682() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6683() {
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6684() {
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6685() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6686() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6687() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6688() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6689() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6690() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6691() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6692() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6693() {
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6694() {
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6695() {
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6696() {
    ss.addAfter(6);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6697() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6698() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6699() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6700() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6701() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6702() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6703() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6704() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6705() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6706() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6707() {
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6708() {
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6709() {
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6710() {
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6711() {
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6712() {
    ss.addAfter(3);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6713() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6714() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(4);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6715() {
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6716() {
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6717() {
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6718() {
    ss.addAfter(2);
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6719() {
    ss.addAfter(5);
    ss.addAfter(4);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

  public void test6720() {
    ss.addAfter(4);
    ss.addAfter(5);
    ss.addAfter(2);
    ss.addAfter(3);
    ss.addAfter(6);
    ss.addAfter(1);
    ss.sort(comp);
    ss.start();
    assertEquals(1,ss.getCurrent().intValue());    ss.advance();
    assertEquals(2,ss.getCurrent().intValue());    ss.advance();
    assertEquals(3,ss.getCurrent().intValue());    ss.advance();
    assertEquals(4,ss.getCurrent().intValue());    ss.advance();
    assertEquals(5,ss.getCurrent().intValue());    ss.advance();
    assertEquals(6,ss.getCurrent().intValue());    ss.advance();
  }

}
