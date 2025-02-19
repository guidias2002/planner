package com.planner.participant;

import com.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParcitipantsToTrip(List<String> participantToIvite, Trip trip) {
        List<Participant> participants = participantToIvite.stream().map(email -> new Participant(email, trip)).toList();

        this.repository.saveAll(participants);

        System.out.println(participants.get(0).getId());
    }

    public ParticipantCreateResponse registerParticipantToTrip(String email, Trip trip) {
        Participant newParticipant = new Participant(email, trip);

        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    public List<ParticipantData> getAllParticipantsFromTrip(UUID tripId) {
        return this.repository.findByTripId(tripId).stream()
                .map(participant -> new ParticipantData(participant.getId(), participant.getName(), participant.getEmail(), participant.getIsConfirmed())).toList();
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId) {}

    public void triggerConfirmationEmailToParticipant(String email) {}
}
