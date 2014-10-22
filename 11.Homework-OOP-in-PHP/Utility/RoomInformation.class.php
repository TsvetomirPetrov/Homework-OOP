<?php
namespace Utility;

use Exception;
use InvalidArgumentException;
use Utility\RoomType;

class RoomInformation {
    private $roomType;
    private $hasRestroom;
    private $hasBalcony;
    private $bedCount;
    private $roomNumber;
    private $extras;
    private $price;

    public function __construct($bedCount, $price, $hasRestroom, $hasBalcony, $extras, $roomNumber, $roomType)
    {
        $this->setBedCount($bedCount);
        $this->setPrice($price);
        $this->setHasRestroom($hasRestroom);
        $this->setHasBalcony($hasBalcony);
        $this->setExtras($extras);
        $this->setRoomNumber($roomNumber);
        $this->setRoomType($roomType);
    }

    public function getBedCount()
    {
        return $this->bedCount;
    }

    public function setBedCount($bedCount)
    {
        if ($bedCount <= 0){
            throw new InvalidArgumentException("Bed count cannot be ne 0 or negative.");
        }
        $this->bedCount = $bedCount;
    }

    public function getExtras()
    {
        return $this->extras;
    }

    public function setExtras($extras)
    {
        if ($extras === null || $extras === ""){
            throw new InvalidArgumentException("Extras cannot be null or empty.");
        }
        $this->extras = $extras;
    }

    public function getHasBalcony()
    {
        return $this->hasBalcony;
    }

    public function setHasBalcony($hasBalcony)
    {
        $this->hasBalcony = $hasBalcony;
    }

    public function getHasRestroom()
    {
        return $this->hasRestroom;
    }

    public function setHasRestroom($hasRestroom)
    {
        $this->hasRestroom = $hasRestroom;
    }

    public function getPrice()
    {
        return $this->price;
    }

    public function setPrice($price)
    {
        if ($price < 0){
            throw new InvalidArgumentException("Invalid price.");
        }
        $this->price = $price;
    }

    public function getRoomNumber()
    {
        return $this->roomNumber;
    }

    public function setRoomNumber($roomNumber)
    {
        if ($roomNumber < 0){
            throw new InvalidArgumentException("Invalid room number.");
        }
        $this->roomNumber = $roomNumber;
    }

    public function getRoomType()
    {
        return $this->roomType;
    }

    public function setRoomType($roomType)
    {
        $this->roomType = $roomType;
    }

    function __toString()
    {
        $hasBalcony = $this->getHasBalcony() ? "Yes" : "No";
        $hasRestroom = $this->getHasRestroom() ? "Yes" : "No";
        
        $result = "Price: " . $this->getPrice() .
            "\nBed count: " . $this->getBedCount() .
            "\nRoom type: " . $this->getRoomType() .
            "\nRoom number: " . $this->getRoomNumber() .
            "\nHas balcony: " . $hasBalcony .
            "\nHas Restroom: " . $hasRestroom .
            "\nExtras: " . $this->getExtras();
        return $result;
    }
} 