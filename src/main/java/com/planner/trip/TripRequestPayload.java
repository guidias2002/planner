package com.planner.trip;

import java.util.List;

public record TripRequestPayload(String destination, String starts_at, String ends_at, List<String> email_to_invite, String owner_email, String owner_name) {
}
