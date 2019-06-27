# DistributionAlgorithm
Algorithm to equally distribute a set of entities (with or without group keys) to buckets representing groups.

# Input
- set of entities (each with or without a group key and an arbitrary value
- a set of weights for buckets

# Algorithm task
- distribute the entities equally across the buckets (representing groups) while honoring
- allocate entities to the corresponding bucket first
  - only allocate entities to other buckets if the corresponding bucket is filled
  
# Output
- a set of buckets, that contain the assigned entities 
