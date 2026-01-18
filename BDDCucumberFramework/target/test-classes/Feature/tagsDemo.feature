Feature: Login feature 

@smoke @sanity @rerun
Scenario: User Login Scenario
	Given User is on Application Login Page
	
@rerun @smoke @sanity
Scenario: User Add Name Scenario
	Given User is on add name page
	
@wdw @dlr @hkdl
Scenario: User Add DOB Scenario
	Given User cicks add dob
	
@dlr @smoke	
Scenario: User Add Salary Scenario
	Given User select the salary dropdown
	
@wdw @sanity
Scenario: User Job Preference Scenario
	Given User selects the job preference
	
@hkdl @rerun	
Scenario: User Skills Set Scenario
	Given User selects the skills available
	
@smoke @sanity @wdw @rerun @dlr	
Scenario: User Location check Scenario
	Given User able to choose location
	
@intergration @rerun
Scenario: User Apply now Scenario
	Given User click on apply button
	