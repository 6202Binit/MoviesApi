package moviesapi.example.MoviesApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WatchlistService {
    @Autowired
    private WatchlistRepo watchrepo;

    public Watchlist addMovieToWatchlist(String userid, Movie movie) {
        Watchlist watchlist = watchrepo.findById(userid).orElse(new Watchlist());
        watchlist.setUserid(userid); // Correct setter for userid

        if (watchlist.getList() == null) { // Correct getter for list
            watchlist.setList(new ArrayList<>());
        }

        watchlist.getList().add(movie); // Correct getter for list
        return watchrepo.save(watchlist);
    }

    public Watchlist removeMovieFromWatchlist(String userid, String movieId) {
        Optional<Watchlist> watchlistOpt = watchrepo.findById(userid);

        if (watchlistOpt.isPresent()) {
            Watchlist watchlist = watchlistOpt.get();
            watchlist.getList().removeIf(movie -> movie.getId().toString().equals(movieId)); // Handle ObjectId correctly
            return watchrepo.save(watchlist);
        }

        return null;
    }

    public Watchlist getWatchlist(String userid) {
        return watchrepo.findById(userid).orElse(new Watchlist());
    }

   /* public Watchlist addMovieToWatchlist(String userid, Movie movie) {
        Watchlist watchlist = watchrepo.findById(userid).orElse(new Watchlist());
        watchlist.setuserId(userid);

        if (watchlist.getMovies() == null) {
            watchlist.setMovies(new ArrayList<>());
        }

        watchlist.getMovies().add(movie);
        return watchrepo.save(watchlist);
    }

    public Watchlist removeMovieFromWatchlist(String userid, String movieId) {
        Optional<Watchlist> watchlistOpt = watchrepo.findById(userid);

        if (watchlistOpt.isPresent()) {
            Watchlist watchlist = watchlistOpt.get();
            watchlist.getMovies().removeIf(movie -> movie.getId().equals(movieId));
            return watchrepo.save(watchlist);
        }

        return null;
    }

    public Watchlist getWatchlist(String userid) {
        return watchrepo.findById(userid).orElse(new Watchlist());
    }*/
}
