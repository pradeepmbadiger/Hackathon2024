package com.hackathon.demo.services;

import com.hackathon.demo.entity.UserDetails;
//import com.microsoft.cognitiveservices.speech.SpeechConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AzureService
{
    @Autowired
    private UserDetailsService userDetailsService;
    public void createUserProfile(UserDetails userDetails, MultipartFile audioFile){
        UserDetails userDetails1 = userDetailsService.createUser(userDetails);
        System.out.println(userDetails1.getProfileId() + " : " + userDetails1.getUserId());
        String speechSubscriptionKey = "";
        String serviceRegion = "centralindia";
        /*
        try (SpeechConfig speechConfig = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
             VoiceProfileClient client = new VoiceProfileClient(speechConfig)) {

            assert(speechConfig != null);
            assert(client != null);
            int exitCode = 1;
            try (VoiceProfile profile1 = client.createProfileAsync(VoiceProfileType.TextIndependentIdentification, "en-us").get();
                 VoiceProfile profile2 = client.createProfileAsync(VoiceProfileType.TextIndependentIdentification, "en-us").get()) {
                assert(profile1 != null);
                assert(profile2 != null);

                if(enrollProfile(client, profile1, audioFile1) && enrollProfile(client, profile2, audioFile2)) {
                    System.out.println(String.format("Enrolled profiles %s and %s for text independent identification", profile1.getId(), profile2.getId()));
                    List<VoiceProfile> profiles = new ArrayList<>();
                    profiles.add(profile1);
                    profiles.add(profile2);
                    String identificationFile = "wikipediaOcelot.wav";
                    identifySpeakers(speechConfig, profiles, identificationFile);
                }
                try (VoiceProfileResult result1 = client.deleteProfileAsync(profile1).get();
                     VoiceProfileResult result2 = client.deleteProfileAsync(profile2).get()) {
                    assert(result1.getReason() == ResultReason.DeletedVoiceProfile);
                    assert(result2.getReason() == ResultReason.DeletedVoiceProfile);
                }
            }
        } catch (Exception ex) {
            System.out.println("Unexpected exception: " + ex.getMessage());

            assert(false);
            System.exit(1);
        }
*/

    }
    public void getUserProfile(int userId){
        UserDetails userDetails1 = userDetailsService.getUserDetailsById(userId);
        System.out.println(userDetails1.getProfileId() + " : " + userDetails1.getUserId());

    }
}
