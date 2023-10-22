# Counting Bloom Filter and Bloom Filter Implementation

This project implements the Counting Bloom Filter and Bloom Filter data structures. These are space-efficient probabilistic data structures used for efficiently checking the presence of elements in a given sequence or determining the number of occurrences of elements.

## Part 1: Counting Bloom Filter

### Introduction

The Counting Bloom Filter is a generalized version of the Bloom Filter, capable of tracking the number of occurrences of elements in a sequence. It stores an integer array of size `m`, independent of the sequence size. The two primary operations in a Counting Bloom Filter are "add" and "lookup." The "add" operation increments counters at specified indices, and the "lookup" operation checks if an element has occurred less than a specified threshold.

## Part 2: Bloom Filter

### Introduction

The Bloom Filter is a bit array of size `m`, used to efficiently check if an element has been encountered in a given sequence. It employs `k` different hash functions for element addition and lookup. The Bloom Filter allows adding elements and performing fast lookups. It may occasionally yield false positive results.

## Conclusion

This project provides implementations of the Counting Bloom Filter and Bloom Filter data structures, offering efficient and space-saving ways to check the presence and number of occurrences of elements in a sequence. It also introduces a custom hash function for these data structures.
