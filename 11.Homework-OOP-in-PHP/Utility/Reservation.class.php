<?php
namespace Utility;

class Reservation {
    private $startDate;
    private $endDate;
    private $guest;


    function __construct($startDate, $endDate, $guest)
    {
        $endDateInTime = $endDate;
        $startDateInTime = $startDate;
        $this->setEndDate($endDateInTime);
        $this->setGuest($guest);
        $this->setStartDate($startDateInTime);
    }

    public function getEndDate()
    {
        return date("d-m-Y", $this->endDate);
    }

    public function setEndDate($endDate)
    {
        $this->endDate = $endDate;
    }

    public function getGuest()
    {
        return $this->guest;
    }

    public function setGuest($guest)
    {
        $this->guest = $guest;
    }

    public function getStartDate()
    {
        return date("d-m-Y", $this->startDate);
    }

    public function setStartDate($startDate)
    {
        $this->startDate = $startDate;
    }

    function __toString()
    {
        $result = "\tReservation( Start date: " . $this->getStartDate() .
            ", End date: " . $this->getEndDate() . ", Guest: {" . $this->getGuest() .
            "} )";
        return $result;
    }
} 