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
package org.apache.usergrid.apm.model;

import org.apache.usergrid.apm.model.ChartCriteria.SamplePeriod;
import org.hibernate.annotations.Index;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "COMPACT_SESSION_METRICS")
@org.hibernate.annotations.Table(appliesTo="COMPACT_SESSION_METRICS",
indexes = {
		@Index(name="SessionMetricsChartMinute", columnNames={"appId","chartCriteriaId","endMinute"} ) ,
		@Index(name="SessionMetricsChartHour", columnNames={"appId","chartCriteriaId","endHour"} )   
} )
public class CompactSessionMetrics implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	Long id;

	
	private String fullAppName;

	private String chartCriteria;

	private Long chartCriteriaId;

	private Long sessionCount;
	private Long sumSessionLength;
	private Long sumSessionUserActivity;
	private Long sumBatteryConsumption;
	private Long numUniqueUsers;



	//Network Parameters
	String networkType;
	String networkCountry;
	String networkCarrier;
	Boolean isNetworkRoaming;

	/**
	 * For same session, a user may go from wifi to 3g. In that case this should be set to true
	 */
	Boolean isNetworkChanged;

	//DeviceParameters
	String deviceId;
	String deviceType;
	String deviceModel;
	String devicePlatform;
	String deviceOperatingSystem;

	/**
	 * battery life in terms of percentage
	 */
	Integer startBatteryLevel;
	Integer endBatteryLevel;

	//Software Versioning Parameters
	String applicationVersion;


	@Column(name="CONFIG_TYPE") 
	String appConfigType;

	Long appId;

	private Date timeStamp;

	Long endMinute;
	Long endHour;
	Long endDay;
	Long endWeek;
	Long endMonth;

	@Enumerated(EnumType.STRING)
	@Column(name="SAMPLE_PERIOD",nullable=false) 
	SamplePeriod samplePeriod;

	@Transient
	private String appConfigTypeString; //this is for work around of problem with addScalar and enum at SessionDBServiceImpl



	/*
   boolean groupedByApp;
   boolean groupedByAppVersion;
   boolean groupedByAppConfigType;
   boolean groupedByDevicePlatform;
   boolean groupedByDeviceModel;
   boolean groupedByNetworkType;
   boolean groupedByNeworkProvider;
	 */




	public String getAppConfigType()
	{
		return appConfigType;
	}

	public void setAppConfigType(String appConfigType)
	{
		this.appConfigType = appConfigType;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	} 


	public String getNetworkType()
	{
		return networkType;
	}

	public void setNetworkType(String networkType)
	{
		this.networkType = networkType;
	}


	public String getNetworkCountry()
	{
		return networkCountry;
	}

	public void setNetworkCountry(String networkCountry)
	{
		this.networkCountry = networkCountry;
	}   


	public String getNetworkCarrier()
	{
		return networkCarrier;
	}

	public void setNetworkCarrier(String networkCarrier)
	{
		this.networkCarrier = networkCarrier;
	}

	public Boolean getIsNetworkRoaming()
	{
		return isNetworkRoaming;
	}

	public void setIsNetworkRoaming(Boolean isNetworkRoaming)
	{
		this.isNetworkRoaming = isNetworkRoaming;
	}

	public String getDeviceType()
	{
		return deviceType;
	}

	public void setDeviceType(String deviceType)
	{
		this.deviceType = deviceType;
	}

	public String getDeviceModel()
	{
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel)
	{
		this.deviceModel = deviceModel;
	}

	public String getDevicePlatform()
	{
		return devicePlatform;
	}

	public void setDevicePlatform(String devicePlatform)
	{
		this.devicePlatform = devicePlatform;
	}

	public String getDeviceOperatingSystem()
	{
		return deviceOperatingSystem;
	}

	public void setDeviceOperatingSystem(String deviceOperatingSystem)
	{
		this.deviceOperatingSystem = deviceOperatingSystem;
	}


	public String getApplicationVersion()
	{
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion)
	{
		this.applicationVersion = applicationVersion;
	}


	public Long getAppId()
	{
		return appId;
	}

	public void setAppId(Long appId)
	{
		this.appId = appId;
	}

	public Integer getStartBatteryLevel()
	{
		return startBatteryLevel;
	}

	public void setStartBatteryLevel(Integer startBatteryLevel)
	{
		this.startBatteryLevel = startBatteryLevel;
	}

	public Integer getEndBatteryLevel()
	{
		return endBatteryLevel;
	}

	public void setEndBatteryLevel(Integer endBatteryLevel)
	{
		this.endBatteryLevel = endBatteryLevel;
	}

	public Boolean getIsNetworkChanged()
	{
		return isNetworkChanged;
	}

	public void setIsNetworkChanged(Boolean isNetworkChanged)
	{
		this.isNetworkChanged = isNetworkChanged;
	}


	public Long getChartCriteriaId()
	{
		return chartCriteriaId;
	}

	public void setChartCriteriaId(Long chartCriteriaId)
	{
		this.chartCriteriaId = chartCriteriaId;
	}

	public Long getSessionCount()
	{
		return sessionCount;
	}

	public void setSessionCount(Long sessionCount)
	{
		this.sessionCount = sessionCount;
	}

	public Long getSumSessionLength()
	{
		return sumSessionLength;
	}

	public void setSumSessionLength(Long sumSessionLength)
	{
		this.sumSessionLength = sumSessionLength;
	}

	public Long getSumSessionUserActivity()
	{
		return sumSessionUserActivity;
	}

	public void setSumSessionUserActivity(Long sumSessionUserActivity)
	{
		this.sumSessionUserActivity = sumSessionUserActivity;
	}

	public Long getSumBatteryConsumption()
	{
		return sumBatteryConsumption;
	}

	public void setSumBatteryConsumption(Long sumBatteryConsumption)
	{
		this.sumBatteryConsumption = sumBatteryConsumption;
	}

	public String getDeviceId()
	{
		return deviceId;
	}

	public void setDeviceId(String deviceId)
	{
		this.deviceId = deviceId;
	}

	public SamplePeriod getSamplePeriod()
	{
		return samplePeriod;
	}

	public void setSamplePeriod(SamplePeriod samplePeriod)
	{
		this.samplePeriod = samplePeriod;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;

		long time = timeStamp.getTime();
		this.endMinute = time / 1000/60;
		this.endHour = this.endMinute / 60;
		this.endDay = this.endHour / 24;
		this.endWeek = this.endDay / 7;
		this.endMonth = this.endDay/30;
	}

	public Long getEndMinute()
	{
		return endMinute;
	}

	public void setEndMinute(Long endMinute)
	{
		this.endMinute = endMinute;
	}

	public Long getEndHour()
	{
		return endHour;
	}

	public void setEndHour(Long endHour)
	{
		this.endHour = endHour;
	}

	public Long getEndDay()
	{
		return endDay;
	}

	public void setEndDay(Long endDay)
	{
		this.endDay = endDay;
	}

	public Long getEndWeek()
	{
		return endWeek;
	}

	public void setEndWeek(Long endWeek)
	{
		this.endWeek = endWeek;
	}

	public Long getEndMonth()
	{
		return endMonth;
	}

	public void setEndMonth(Long endMonth)
	{
		this.endMonth = endMonth;
	}

	public Long getNumUniqueUsers()
	{
		return numUniqueUsers;
	}

	public void setNumUniqueUsers(Long numUniqueUsers)
	{
		this.numUniqueUsers = numUniqueUsers;
	} 
	

	public String getFullAppName() {
		return fullAppName;
	}

	public void setFullAppName(String fullAppName) {
		this.fullAppName = fullAppName;
	}

	public String getChartCriteria() {
		return chartCriteria;
	}

	public void setChartCriteria(String chartCriteria) {
		this.chartCriteria = chartCriteria;
	}

	public String toString () {
		return appId + " " + " deviceModel " + deviceModel  + " devicePlatform " + devicePlatform + " time : " + timeStamp;
	}



}
