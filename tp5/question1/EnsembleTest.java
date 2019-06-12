package question1;

public class EnsembleTest extends junit.framework.TestCase {

	public void UnionTest() {

		question1.Ensemble<Integer> e1, e2;


		e1 = new question1.Ensemble<Integer>();

		assertEquals(true, e1.add(1));
		assertEquals(true, e1.add(2));

		e2 = new question1.Ensemble<Integer>();

		assertEquals(true, e2.add(2));
		assertEquals(true, e2.add(3));

		question1.Ensemble<Integer> union = e1.union(e2);

		assertEquals(3, union.size());

		assertTrue(union.contains(1));
		assertTrue(union.contains(2));
		assertTrue(union.contains(3));
	}
	
	public void InterTest() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));

		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(4));

		question1.Ensemble<Integer> inter = e1.inter(e2);
		assertEquals(1, inter.size());
		assertFalse(inter.contains(2));
		assertTrue(inter.contains(3));
		assertFalse(inter.contains(4));
	}
	public void DiffTest() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));

		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(4));

		question1.Ensemble<Integer> diff = e1.diff(e2);
		assertEquals(1, diff.size());
		assertTrue(diff.contains(2));
		assertFalse(diff.contains(3));
		assertFalse(diff.contains(4));
	}
	public void DiffSymTest() {
		question1.Ensemble<Integer> e1, e2;
		e1 = new question1.Ensemble<Integer>();
		assertEquals(true, e1.add(2));
		assertEquals(true, e1.add(3));

		e2 = new question1.Ensemble<Integer>();
		assertEquals(true, e2.add(3));
		assertEquals(true, e2.add(4));

		question1.Ensemble<Integer> diffSym = e1.diffSym(e2);
		assertEquals(2, diffSym.size());
		assertTrue(diffSym.contains(2));
		assertFalse(diffSym.contains(3));
		assertTrue(diffSym.contains(4));
	}
	
	public void testAdd(){ 
	    question1.Ensemble<String> a = new question1.Ensemble<String>();
		String str="testing";
		String str1="ultra";
	    assertEquals(true, a.add(str));
		assertEquals(false, a.add(str));
		assertEquals(false, a.add(str));
		assertEquals(true, a.add(str1));
	   }
	
	
	
}
