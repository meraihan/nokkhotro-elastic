package com.datasoft.proshomon.backend.model;

public class Strings {
    /**
     * Date format for saving in elasticsearch
     */
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";

    /**
     * Error message shown when trying to create new prescription but previous prescription is still OPEN.
     */
    public static final String OPEN_PRESCRIPTION = "FAILED TO OPEN NEW PRESCRIPTION, PREVIOUS PRESCRIPTIONS ARE NOT CLOSED";

    /**
     * Date format for saving in elasticsearch
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Error message shown when trying to update a closed prescription
     */
    public static final String CLOSED_PRESCRIPTION = "Attempt to update a closed prescription";

    /**
     * Error message shown when no prescription is found
     */
    public static final String PRESCRIPTION_NOT_FOUND = "No Prescription found";

    /**
     * Error message shown when prescription is not valid
     */
    public static final String PRESCRIPTION_NOT_VALID = "Provided prescription does not match existing prescription";

    /**
     * Error message shown when no household is found
     */
    public static final String HOUSEHOLD_NOT_FOUND = "Household not found";

    /**
     * Error message shown when no beneficiary is found
     */
    public static final String BENEFICIARY_NOT_FOUND = "Beneficiary not found";
	
	/**
	 * Error message shown when no DIAGNOSTIC is found
	 */
	public static final String DIAGNOSTIC_TEST_NOT_FOUND = "Diagnostic Test Not found";
	
	/**
	 * Error message shown when no SURGERY is found
	 */
	public static final String SURGERY_NOT_FOUND = "Surgery not found";
	
	/**
	 * Error message shown when no MEDICINE is found
	 */
	public static final String MEDICINE_NOT_FOUND = "Medicine not found";
	
	/**
	 * Error message shown when area not found with this area code
	 */
	public static final String AREA_NOT_FOUND = "No workable match of parameters found in the request";
	
	/**
	 * Error message shown when Image format for upload does not match
	 */
	public static final String TYPE_MISMATCH = "Only image (.jpg, .jpeg, .png) formats allowed!";
	
    /**
     * Error message shown when services provider not found
     */
    public static final String SERVICE_PROVIDER_NOT_FOUND = "Service provider not found";
    
	/**
	 * Error message shown when consultation is not found
	 */
	public static final String CONSULTATION_NOT_FOUND = "No Consultation found";
	
	/**
	 * Error message shown when no match is found (general)
	 */
	public static final String NO_MATCH = "No Match found";
	
	/**
	 * Error message shown when action performed is invalid in general
	 */
	public static final String INVALID_ACTION_GENERAL = "The action can not be performed";
	
	/**
	 * Error message shown when price is invalid
	 */
	public static final String INVALID_PRICE_SURGERY = "The action can not be performed since surgery price is invalid";
	
	/**
	 * Error message shown when price is invalid
	 */
	public static final String INVALID_PRICE_DIAGNOSTIC_TEST = "The action can not be performed since diagnostic test price is invalid";
	
	/**
	 * Error message shown when price is invalid
	 */
	public static final String INVALID_PRICE_CONSULTATION = "The action can not be performed since consultation price is invalid";
	
	/**
	 * Error message shown when medicine allocated/provided number is invalid
	 */
	public static final String INVALID_NUMBERS_MEDICINE = "Allocated/Provided numbers are invalid";

    /**
     * Error message shown when household have not sufficient balance
     */
    public static final String TRANSACTION_INSUFFICIENT_BALANCE = "Insufficient balance";

	/**
	 * Error message shown when services information provided is does not match any required template
	 * e.g. A services marked as done in existing prescription
	 */
	public static final String INVALID_SERVICE_INFORMATION = "Service information provided is invalid";
	/**
	 * Error message shown when transaction failed with no definite cause identified.
	 */
	public static final String TRANSACTION_FAILED_UNKNOWN = "Transaction Failed due to unknown reason. Please contact your administrator.";

	/**
	 * Error message shown when services category is not match with service category enum
	 */
	public static final String INVALID_SERVICE_CATEGORY = "Service category is invalid. It should be a string from the following: PHC, MATERNITY, ACCIDENT";

	/**
	 * Error message shown when fingerprint key not equal 2 template
	 */
	public static final String FINGERPRINT_DATA_PROBLEM = "Provided fingerprint template should be 2";
	/**
	 * Error message shown when user is not found
	 */
	public static final String USER_NOT_FOUND = "User not found";
	/**
	 * Error message shown when user is not a service provider, may be admin or other user.
	 */
	public static final String NOT_A_SERVICE_PROVIDER = "The authenticated user is not a valid service provider";
}
