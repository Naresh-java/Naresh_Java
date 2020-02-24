package com.freecrm.qa.Analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformer implements IAnnotationTransformer{
	public void transform(ITestAnnotation annotation,Class testClass,
			Constructor constructor,Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
