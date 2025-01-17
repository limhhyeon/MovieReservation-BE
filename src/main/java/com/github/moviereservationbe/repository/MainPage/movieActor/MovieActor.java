package com.github.moviereservationbe.repository.MainPage.movieActor;


import com.github.moviereservationbe.repository.MainPage.actor.Actor;
import com.github.moviereservationbe.repository.MainPage.movie.Movie;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "movie_actor")
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "movie_actor_id")
    private Integer movieActorId;

    @ManyToOne
    @JoinColumn(name= "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name= "actor_id")
    private Actor actor;
}