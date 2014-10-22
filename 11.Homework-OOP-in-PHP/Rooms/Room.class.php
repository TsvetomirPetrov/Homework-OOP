<?php
namespace Rooms;

use InterfacesAndExceptions\EReservationException;
use InterfacesAndExceptions\iReservable;
use Utility\Reservation;
use Utility\RoomInformation;

abstract class Room implements iReservable{
    protected  $roomInformation;
    protected $reservations = [];

    protected function __construct(RoomInformation $roomInformation)
    {
        $this->setRoomInformation($roomInformation);
    }

    public function getReservations()
    {
        return $this->reservations;
    }

    protected function setReservations($reservations)
    {
        $this->reservations[] = $reservations;
    }

    public function getRoomInformation()
    {
        return $this->roomInformation;
    }

    public function setRoomInformation($roomInformation)
    {
        $this->roomInformation = $roomInformation;
    }

    public function addReservation($reservation)
    {
        if (($key = array_search($reservation, $this->reservations)) !== false) {
            throw new EReservationException();
        }

        foreach ($this->getReservations() as $thisReservation) {
            if ( (strtotime($thisReservation->getStartDate()) <= strtotime($reservation->getStartDate() ) &&
                    strtotime($reservation->getStartDate()) <= strtotime($thisReservation->getEndDate()) ) ||
                (strtotime($thisReservation->getStartDate()) <= strtotime($reservation->getEndDate() ) &&
                    strtotime($reservation->getEndDate()) <= strtotime($thisReservation->getEndDate()) ) ||
                (strtotime($reservation->getStartDate()) < strtotime($thisReservation->getStartDate() ) &&
                    strtotime($reservation->getEndDate()) > strtotime($thisReservation->getEndDate()) )
            ) {
                throw new EReservationException("Room is reserved for this date.");
            }
        }
        $this->setReservations($reservation);

        array_multisort($this->reservations);
    }

    public function removeReservation($reservation)
    {
        if(($key = array_search($reservation, $this->reservations)) !== false) {
            unset($this->reservations[$key]);
        } else {
            throw new EReservationException("There is no such reservation.");
        }
    }

    function __toString()
    {
        $result = "\n" . get_class($this) . " -> Room information: \n" . $this->getRoomInformation() . "\nReservations: \n";
        if (count($this->getReservations()) > 0){
            foreach($this->getReservations() as $item){
                $result .= "$item \n";
            }
        } else {
            $result .= "\tNo reservations";
        }
        return $result;
    }
} 