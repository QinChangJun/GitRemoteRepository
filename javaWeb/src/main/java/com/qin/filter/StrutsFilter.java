package com.qin.filter;

import javax.servlet.annotation.WebFilter;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

@WebFilter("/*")
public class StrutsFilter extends StrutsPrepareAndExecuteFilter {

}
