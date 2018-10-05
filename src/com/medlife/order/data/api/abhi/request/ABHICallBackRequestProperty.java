package com.medlife.order.data.api.abhi.request;

public class ABHICallBackRequestProperty {

    private static String dateFormate = "yyyy-MM-dd";

    // Status Request:Fields Constants
    private static String sourceSystemCode = "Medlife";

    // Cancelation_Remark
    private static String cancelationRemark = "Wrong Intimation";

    // Closer Remarks
    private static String preAuthCloseRemarks = "PAC Close";

    // Bill Entry : PreAuthHospi
    private static String hospitalizationType = "NONICU";
    private static String serviceFlag = "Create";
    private static String hospitalCode = "PH00000006";

    // Bill Entry : BillEntry Obj
    private static String coverPartAffectedCode = "DR007";
    private static String subCategoryName = "Medicines";
    private static String categoryName = "Medicines";
    private static String noOfVisit = "1";
    private static String LOINCCode = "";
    private static String ICD10Code = "A0.1";

    public static String getDateFormate() {
	return dateFormate;
    }

    public static void setDateFormate(String dateFormate1) {
	dateFormate = dateFormate1;
    }

    public static String getSourceSystemCode() {
	return sourceSystemCode;
    }

    public static void setSourceSystemCode(String sourceSystemCode1) {
	sourceSystemCode = sourceSystemCode1;
    }

    public static String getCancelationRemark() {
	return cancelationRemark;
    }

    public static void setCancelationRemark(String cancelationRemark1) {
	cancelationRemark = cancelationRemark1;
    }

    public static String getPreAuthCloseRemarks() {
	return preAuthCloseRemarks;
    }

    public static void setPreAuthCloseRemarks(String preAuthCloseRemarks1) {
	preAuthCloseRemarks = preAuthCloseRemarks1;
    }

    public static void setCoverPartAffectedCode(String coverPartAffectedCode1) {
	coverPartAffectedCode = coverPartAffectedCode1;
    }

    public static void setSubCategoryName(String subCategoryName1) {
	subCategoryName = subCategoryName1;
    }

    public static void setCategoryName(String categoryName1) {
	categoryName = categoryName1;
    }

    public static void setNoOfVisit(String noOfVisit1) {
	noOfVisit = noOfVisit1;
    }

    public static void setLOINCCode(String LOINCCode1) {
	LOINCCode = LOINCCode1;
    }

    public static void setICD10Code(String ICD10Code1) {
	ICD10Code = ICD10Code1;
    }

    public static String getCoverPartAffectedCode() {
	return coverPartAffectedCode;
    }

    public static String getSubCategoryName() {
	return subCategoryName;
    }

    public static String getCategoryName() {
	return categoryName;
    }

    public static String getNoOfVisit() {
	return noOfVisit;
    }

    public static String getLOINCCode() {
	return LOINCCode;
    }

    public static String geICD10Codet() {
	return ICD10Code;
    }

    public static String getHospitalizationType() {
	return hospitalizationType;
    }

    public static String getServiceFlag() {
	return serviceFlag;
    }

    public static String getHospitalCode() {
	return hospitalCode;
    }

    public static void setHospitalizationType(String hospitalizationType1) {
	hospitalizationType = hospitalizationType1;
    }

    public static void setServiceFlag(String serviceFlag1) {
	serviceFlag = serviceFlag1;
    }

    public static void setHospitalCode(String hospitalCode1) {
	hospitalCode = hospitalCode1;
    }
}
