<?php

// A function that prints a message to the console (Out stream) 
function debug($msg) {
    $stdout = fopen('php://stdout', 'w');
    $bt = debug_backtrace();
    $caller = array_shift($bt);
    $file = realpath($caller['file']);
    $line = $caller['line'];
    $debug = "[".date('Y-m-d H:i:s')."]" . " DEBUG: {$file}:{$line} ";
    fwrite($stdout, $debug.(is_array($msg) || is_object($msg) ? print_r($msg, true) : $msg) . PHP_EOL);
}