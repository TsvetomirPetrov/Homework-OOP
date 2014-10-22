<?php
namespace Utility;

use InvalidArgumentException;

class Guest {
    private $firstName;
    private $lastName;
    private $id;

    function __construct($firstName, $lastName, $id)
    {
        $this->setFirstName($firstName);
        $this->setId($id);
        $this->setLastName($lastName);
    }

    public function getFirstName()
    {
        return $this->firstName;
    }

    public function setFirstName($firstName)
    {
        if ($firstName === null || $firstName === ""){
            throw new InvalidArgumentException("First name cannot be null or empty.");
        }
        $this->firstName = $firstName;
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        if (!is_numeric($id)){
            throw new InvalidArgumentException("Id must be numeric.");
        }
        $this->id = $id;
    }

    public function getLastName()
    {
        return $this->lastName;
    }

    public function setLastName($lastName)
    {
        if ($lastName === null || $lastName === ""){
            throw new InvalidArgumentException("Last name cannot be null or empty.");
        }
        $this->lastName = $lastName;
    }

    function __toString()
    {
        $result = $this->getFirstName() . " " . $this->getLastName() . ", " . "EGN: " . $this->getId();
        return $result;
    }
} 