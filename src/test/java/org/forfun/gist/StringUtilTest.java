package org.forfun.gist;

import junit.framework.Assert;

import org.forfun.gist.similarity.util.StringUtil;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testRemoveDuplicated() {
		
		Assert.assertEquals("abcdegj", StringUtil.removeDuplicated("aaaabbbbcccdegggj"));
		Assert.assertEquals("shep", StringUtil.removeDuplicated("sheeeeep"));
	
	}

}
