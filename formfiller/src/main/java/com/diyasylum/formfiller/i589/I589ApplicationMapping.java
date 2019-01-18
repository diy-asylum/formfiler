package com.diyasylum.formfiller.i589;

import com.diyasylum.formfiller.application.models.*;
import com.diyasylum.formfiller.mappings.AbstractMapper;
import java.util.*;
import java.util.function.Function;

abstract class I589ApplicationMapping {
  // Right now this is mapping to string. This may eventually map to an object taking in a string
  // Basically "Give me a field and ill give you the object which gives you the text to validate and
  // fill in that field"
  static Map<String, Function<I589Application, String>> PDF_FIELD_MAP;

  static {
    Map<String, Function<I589Application, String>> pdfFieldMap = new HashMap<>();
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine1_ANumber[0]",
        a -> AbstractMapper.noneIfBlank(a.getApplicantInfo().getAlienRegistrationNumber()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[0]", a -> a.getApplicantInfo().getSocialSecurityNumber());
    pdfFieldMap.put(
        "form1[0].#subform[10].USCISOnlineAcctNumber[0]",
        a -> AbstractMapper.noneIfBlank(a.getApplicantInfo().getUSISAccountNumber()));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine4_LastName[0]",
        a -> AbstractMapper.naIfBlank(a.getApplicantInfo().getLastName()));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine8_StreetNumandName[0]",
        a ->
            String.join(
                " ",
                a.getApplicantInfo().getUsResidence().getStreetNumber(),
                a.getApplicantInfo().getUsResidence().getStreetName()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[1]",
        a -> String.join(",", a.getApplicantInfo().getAliases()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[2]", a -> a.getApplicantInfo().getUsResidence().getCity());
    pdfFieldMap.put(
        "form1[0].#subform[0].DateTimeField1[0]", a -> a.getApplicantInfo().getDateOfBirth());
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[3]", a -> a.getApplicantInfo().getPresentNationality());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine5_FirstName[0]",
        a -> AbstractMapper.naIfBlank(a.getApplicantInfo().getFirstName()));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine6_MiddleName[0]",
        a -> AbstractMapper.naIfBlank(a.getApplicantInfo().getMiddleName()));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine8_AreaCode[0]",
        a -> a.getApplicantInfo().getUsResidence().getAreaCode());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine8_TelephoneNumber[0]",
        a -> a.getApplicantInfo().getUsResidence().getPhoneNumber());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine8_AptNumber[0]",
        a -> a.getApplicantInfo().getUsResidence().getApartmentNumber());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine8_State[0]",
        a -> a.getApplicantInfo().getUsResidence().getState());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine8_Zipcode[0]",
        a -> a.getApplicantInfo().getUsResidence().getZipCode());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_AptNumber[0]",
        a -> a.getApplicantInfo().getUsMailingAddress().getApartmentNumber());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_StreetNumandName[0]",
        a ->
            String.join(
                " ",
                a.getApplicantInfo().getUsResidence().getStreetNumber(),
                a.getApplicantInfo().getUsResidence().getStreetName()));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_ZipCode[0]",
        a -> a.getApplicantInfo().getUsMailingAddress().getZipCode());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_City[0]",
        a -> a.getApplicantInfo().getUsMailingAddress().getCity());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_State[0]",
        a -> a.getApplicantInfo().getUsMailingAddress().getState());
    pdfFieldMap.put(
        "form1[0].#subform[0].PartALine9Gender[0]",
        a -> AbstractMapper.formatCheckbox(a.getApplicantInfo().getGender() == Gender.MALE, "M"));
    pdfFieldMap.put(
        "form1[0].#subform[0].PartALine9Gender[1]",
        a -> AbstractMapper.formatCheckbox(a.getApplicantInfo().getGender() == Gender.FEMALE, "F"));
    pdfFieldMap.put(
        "form1[0].#subform[0].Marital[0]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getMaritalStatus() == MaritalStatus.SINGLE, "S"));
    pdfFieldMap.put(
        "form1[0].#subform[0].Marital[1]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getMaritalStatus() == MaritalStatus.MARRIED, "M"));
    pdfFieldMap.put(
        "form1[0].#subform[0].Marital[2]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getMaritalStatus() == MaritalStatus.DIVORCED, "D"));
    pdfFieldMap.put(
        "form1[0].#subform[0].Marital[3]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getMaritalStatus() == MaritalStatus.WIDOWED, "W"));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[4]",
        a ->
            String.join(
                " ",
                a.getApplicantInfo().getCityOfBirth(),
                a.getApplicantInfo().getCountryOfBirth()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[5]", a -> a.getApplicantInfo().getNationalityAtBirth());
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[6]",
        a -> a.getApplicantInfo().getRaceEthnicOrTribalGroup());
    pdfFieldMap.put("form1[0].#subform[0].TextField1[7]", a -> a.getApplicantInfo().getReligion());
    pdfFieldMap.put(
        "form1[0].#subform[0].CheckBox3[0]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getImmigrationCourtHistory() == ImmigrationCourtHistory.NEVER,
                "A"));
    pdfFieldMap.put(
        "form1[0].#subform[0].CheckBox3[1]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getImmigrationCourtHistory()
                    == ImmigrationCourtHistory.NOT_NOW_BUT_IN_THE_PAST,
                "C"));
    pdfFieldMap.put(
        "form1[0].#subform[0].CheckBox3[2]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().getImmigrationCourtHistory()
                    == ImmigrationCourtHistory.CURRENTLY,
                "B"));
    pdfFieldMap.put(
        "form1[0].#subform[0].DateTimeField6[0]",
        a -> a.getUsTravelHistory().getLastLeftHomeCountry());
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField3[0]",
        a -> AbstractMapper.noneIfBlank(a.getUsTravelHistory().getI94Number()));
    pdfFieldMap.put(
        "form1[0].#subform[0].DateTimeField2[0]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 0)
                .map(UsTravelEvent::getDate)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField4[0]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 0)
                .map(UsTravelEvent::getPlace)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField4[1]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 0)
                .map(UsTravelEvent::getStatus)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].DateTimeField3[0]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 1)
                .map(UsTravelEvent::getDate)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField4[2]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 1)
                .map(UsTravelEvent::getPlace)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField4[3]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 1)
                .map(UsTravelEvent::getStatus)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].DateTimeField4[0]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 2)
                .map(UsTravelEvent::getDate)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField4[4]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 2)
                .map(UsTravelEvent::getPlace)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField4[5]",
        a ->
            AbstractMapper.safeListAccess(a.getUsTravelHistory().getTravelEvents(), 2)
                .map(UsTravelEvent::getStatus)
                .orElse(""));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField5[0]",
        a -> AbstractMapper.noneIfBlank(a.getApplicantInfo().getCountryWhoLastIssuedPassport()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField5[1]",
        a -> AbstractMapper.noneIfBlank(a.getApplicantInfo().getPassportNumber()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField5[2]",
        a -> AbstractMapper.noneIfBlank(a.getApplicantInfo().getTravelDocumentNumber()));
    pdfFieldMap.put(
        "form1[0].#subform[0].CheckBox31[0]",
        a ->
            AbstractMapper.formatCheckbox(
                a.getApplicantInfo().isAlsoApplyingConventionAgainstTorture(), "1"));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_AreaCode[0]",
        a -> a.getApplicantInfo().getUsMailingAddress().getAreaCode());
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_TelephoneNumbe[0]",
        a -> a.getApplicantInfo().getUsMailingAddress().getPhoneNumber());
    pdfFieldMap.put("form1[0].#subform[0].DateTimeField2[1]", a -> "");
    pdfFieldMap.put(
        "form1[0].#subform[0].DateTimeField2[2]",
        a -> AbstractMapper.naIfBlank(a.getApplicantInfo().getTravelDocumentExpirationDate()));
    pdfFieldMap.put(
        "form1[0].#subform[0].PtAILine9_InCareOf[0]",
        a -> AbstractMapper.naIfBlank(a.getApplicantInfo().getUsMailingAddress().getInCareOf()));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField7[0]", a -> a.getApplicantInfo().getNativeLanguage());
    pdfFieldMap.put(
        "form1[0].#subform[0].CheckBox4[0]",
        a -> AbstractMapper.formatCheckbox(a.getApplicantInfo().isFluentInEnglish(), "Yes"));
    pdfFieldMap.put(
        "form1[0].#subform[0].CheckBox4[1]",
        a -> AbstractMapper.formatCheckbox(!a.getApplicantInfo().isFluentInEnglish(), "No"));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField7[1]",
        a ->
            AbstractMapper.noneIfBlank(String.join(",", a.getApplicantInfo().getOtherLanguages())));
    pdfFieldMap.put(
        "form1[0].#subform[0].TextField1[8]",
        a -> AbstractMapper.noneIfBlank(a.getApplicantInfo().getUSISAccountNumber()));

    // Using map.entries causes a compile warning so im reverting to this
    I589ApplicationMapping.PDF_FIELD_MAP = Collections.unmodifiableMap(pdfFieldMap);
  }
}
