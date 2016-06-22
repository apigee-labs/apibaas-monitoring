/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.usergrid.apm.service.charts.service;

import java.util.ArrayList;
import java.util.List;

public class NetworkMetricsChartDTO implements ChartDTO<NetworkMetricsChartDataPoint> {


	private String chartGroupName;

	private List<NetworkMetricsChartDataPoint> datapoints;

	public NetworkMetricsChartDTO () {
		datapoints = new ArrayList<NetworkMetricsChartDataPoint>();


	}

	public String getChartGroupName() {
		return chartGroupName;
	}

	public void setChartGroupName(String chartGroupName) {
		this.chartGroupName = chartGroupName;
	}

	public List<NetworkMetricsChartDataPoint> getDatapoints() {
		return datapoints;
	}

	public void setDatapoints(List<NetworkMetricsChartDataPoint> datapoints) {
		this.datapoints = datapoints;
	}

	public void addDataPoint (NetworkMetricsChartDataPoint dp)  {
		datapoints.add(dp);
	}
	
	public String toString() {
		String string = "ChartGroupName " + chartGroupName + "\n";
		String dp ="";
		for (int i = 0; i < datapoints.size(); i++)
			dp+= datapoints.get(i).toString()+"\n";
		return string+dp;
		
	}



}
