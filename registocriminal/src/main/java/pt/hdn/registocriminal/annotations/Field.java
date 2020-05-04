package pt.hdn.registocriminal.annotations;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@StringDef({})
public @interface Field {
    String NAME = "name";
    String PLACE_OF_BIRTH = "placeOfBirth";
    String TOWN_OF_BIRTH = "townOfBirth";
    String DATE_OF_BIRTH = "dateOfBirth";
    String NATIONALITY = "nationality";
    String IDENTITY_CARD_NUMBER = "identityCardNumber";
    String REQUEST_PURPOSE = "requestPurpose";
    String JOB_SPECIFICATION = "jobSpecification";
    String ACTIVITY_INVOLVING_REGULAR_CONTACTS_WITH_CHILDREN = "activityInvolvingRegularContactsWithChildren";
    String CREATION_DATE = "creationDate";
    String ACCESS_CODE = "accessCode";
    String EXPIRATION_DATE = "expirationDate";
    String ISSUER_TIMESTAMP = "issuerTimestamp";
    String ISSUER_SIGNATURE = "issuerSignature";
    String EVENTS = "events";
}
