package com.github.pikorise.horned;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    @GetMapping("/fib")
    public long getFibonacci(@RequestParam int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be >= 0");
        }
        return fib(number);
    }

    private long fib(int n) {
        if (n == 0) return 0L;
        if (n == 1) return 1L;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}