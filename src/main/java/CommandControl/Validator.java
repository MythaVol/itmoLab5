package CommandControl;

import MusicBands.MusicGenre;

import java.util.regex.Pattern;

public class Validator {
//        public boolean validate(String string){
//            Pattern.matches("")
//            return
//        }

        public MusicGenre getGenre(String genre) throws Exception {
            switch (genre){
                case("hip-hop"):
                    return MusicGenre.HIP_HOP;
                case("jazz"):
                    return MusicGenre.JAZZ;
                case("soul"):
                    return MusicGenre.SOUL;
                default:
                    throw new Exception("Жанр введен неверно");
            }
        }
}
