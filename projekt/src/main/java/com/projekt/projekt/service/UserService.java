package com.projekt.projekt.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekt.projekt.model.User;
import com.projekt.projekt.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersWithHighestAverageRating(int numberOfUsers) {
        List<User> users = userRepository.findAll();

        // Iterate through each user and calculate the average rating
        for (User user : users) {
            Double averageRating = userRepository.getAverageRatingByUserId(user.getId());

            // Check if averageRating is not null before setting it
            if (averageRating != null) {
                user.setAverageRating(averageRating);
            } else {
                // Set a default value or handle the case where the average rating is null
                user.setAverageRating(0.0); // You can set it to any default value
            }
        }

        // Sort users based on average rating in descending order
        users.sort((user1, user2) -> Double.compare(user2.getAverageRating(), user1.getAverageRating()));

        // Return the specified number of users with the highest average rating
        return users.stream().limit(numberOfUsers).collect(Collectors.toList());
    }

}
