<?php

/**
 * PHP Test - Check if Class private variable
 * can be referenced from outside the class
 * using class method and an outside callback
 * function
 */

class PrivateClass
{
    private $var = 'Hi! I am a private variable';

    public function call(callable $cb)
    {
        return $cb($this->var);
    }

    public function echo ()
    {
        echo $this->var, PHP_EOL;
    }
}

$cb1 = function (&$var) {
    $var = 'Hi! I am a private variable, but I am changed';
};

$cb2 = function (&$var) {
    $var = 'Hi! I am a private variable, but I am changed again';
};

$pc = new PrivateClass();
$pc->echo();
$pc->call($cb1);
$pc->echo();
$pc->call($cb2);
$pc->echo();