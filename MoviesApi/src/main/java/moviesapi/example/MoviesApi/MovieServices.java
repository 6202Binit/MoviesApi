package moviesapi.example.MoviesApi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    @Autowired
    private MovieRepo movierepository;
    public List<Movie> allMovies(){

        return movierepository.findAll();
    }
    public Optional<Movie>singleMovie(String imdbId){
        return movierepository.findMovieByImdbId(imdbId);
    }
}
