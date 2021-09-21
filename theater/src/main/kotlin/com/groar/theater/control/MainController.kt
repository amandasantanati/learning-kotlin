package com.groar.theater.control

import com.groar.theater.service.BookingService
import com.groar.theater.service.TheaterService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class MainController {

    private val log: Logger = LoggerFactory.getLogger(MainController::class.java)

    @Autowired
    lateinit var theaterService: TheaterService

    @Autowired
    lateinit var bookingService: BookingService

    @RequestMapping
    fun homePage() : ModelAndView {
        log.info("Rendering home page")

        return ModelAndView("seatBooking", "bean", CheckAvailabilityBackingBean())
    }

    @RequestMapping("/checkAvailability", method = [POST])
    fun checkAvailability(bean: CheckAvailabilityBackingBean) : ModelAndView {
        log.info("Checking availability")

        val selectedSeat = theaterService.find(bean.selectedSeatNum, bean.selectedSeatRow)
        val result = bookingService.isSeatFree(selectedSeat)
        bean.result = "Seat $selectedSeat is " + if(result) "available" else "booked"

        return  ModelAndView("seatBooking", "bean", bean)
    }
}

class CheckAvailabilityBackingBean() {
    val seatNums = 1..36
    val seatRows = 'A'..'O'
    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var result: String = ""
}