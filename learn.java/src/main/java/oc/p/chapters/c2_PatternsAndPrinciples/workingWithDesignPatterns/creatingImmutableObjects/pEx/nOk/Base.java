package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.creatingImmutableObjects.pEx.nOk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Base
{
	final private int b;
	private final List<String> lst;

	Base(int b, List<String> lst)
	{
		this.b = b;
		if (lst == null)
		{
			throw new RuntimeException();
		}
		this.lst = new ArrayList<>(lst);
	}


	protected int getB()
	{
		return b;
	}

	// this method can be overridden and the lst can be hidden
	protected List<String> getLst()
	{
		return Collections.unmodifiableList(lst);
	}
}
