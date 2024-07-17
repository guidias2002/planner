package com.planner.link;

import com.planner.trip.Trip;

public record LinkRequestPayload(String title, String link, Trip trip) {
}
