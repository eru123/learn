<?php

require_once __DIR__ . '/vendor/autoload.php';

/**
 * A Demo & Experiment of PHP Magic Methods
 */
class A
{
    protected function f__add($query)
    {
        $this->query[] = $query;
        return $this;
    }

    protected $query = [];

    protected function f__query()
    {
        return print_r($this->query, true);
    }

    public function __call($name, $arguments)
    {
        // return call_user_func_array([$this, 'f__' . $name], $arguments);
        // check if method exists
        if (method_exists($this, 'f__' . $name)) {
            return call_user_func_array([$this, 'f__' . $name], $arguments);
        }

        throw new \Exception('Call to a member function ' . $name . '(' . implode(', ', $arguments) . ') on null');
    }

    public static function __callStatic($name, $arguments)
    {
        // return call_user_func_array([new self, 'f__' . $name], $arguments);
        // check if method exists
        $x = new self;
        if (method_exists($x, 'f__' . $name)) {
            return call_user_func_array([$x, 'f__' . $name], $arguments);
        }

        throw new \Exception('Call to a member function ' . $name . '(' . implode(', ', $arguments) . ') on null');
    }
}

echo A::sadd('test')->add('123')->query(), PHP_EOL;