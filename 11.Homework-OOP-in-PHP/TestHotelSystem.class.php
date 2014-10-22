<?php

use Rooms\Apartment;
use Rooms\Room;
use Rooms\SingleRoom;
use Rooms\BedRoom;
use Utility\Guest;
use Utility\Reservation;
use Utility\BookingManager;

require_once("Utility/RoomInformation.class.php");
require_once("InterfacesAndExceptions/EReservationException.class.php");
require_once("InterfacesAndExceptions/iReservable.php");
require_once("Rooms/Room.class.php");
require_once("Rooms/SingleRoom.class.php");
require_once("Utility/Guest.class.php");
require_once("Utility/Reservation.class.php");
require_once("Utility/RoomType.class.php");
require_once("Utility/BookingManager.class.php");
require_once("Rooms/Apartment.class.php");
require_once("Rooms/BedRoom.class.php");

$room = new Apartment(1408, 500);
$guest = new Guest("Svetlin", "Nakov", 8003224277);
$startDate = strtotime("24.10.2014");
$endDate = strtotime("26.10.2014");
$reservation = new Reservation($startDate, $endDate, $guest);
BookingManager::bookRoom($room, $reservation);
$secondRoom = new Apartment(101, 120);
BookingManager::bookRoom($secondRoom, $reservation);
$thirdRoom = new BedRoom(543, 250);
BookingManager::bookRoom($thirdRoom, $reservation);
$fourthRoom = new SingleRoom(666, 60);
BookingManager::bookRoom($fourthRoom, $reservation);

$arrayOfRooms = [$room, $secondRoom, $thirdRoom, $fourthRoom];

$apartmentsAndBedrooms = array_filter($arrayOfRooms, function (Room $r) {
    return ($r instanceof BedRoom || $r instanceof Apartment) && ($r->getRoomInformation()->getPrice() <= 250.00);
});
var_dump($apartmentsAndBedrooms);

$roomsWithBalcony = array_filter($arrayOfRooms, function (Room $r) {
    return $r->getRoomInformation()->getHasBalcony();
});
var_dump($roomsWithBalcony);

$roomNumbersOfRoomsWithBathtub = array_map(function (Room $r) {
    $extras = $r->getRoomInformation()->getExtras();
    $roomNumber = $r->getRoomInformation()->getRoomNumber();
    if (preg_match("/bathtub/", $extras)) {
        return $roomNumber;
    }
}, $arrayOfRooms);

print_r($roomNumbersOfRoomsWithBathtub);

