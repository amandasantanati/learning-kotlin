package com.groar.theater.service

import com.groar.theater.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService {

    fun isSeatFree(seat: Seat) : Boolean {
        return true
    }
}