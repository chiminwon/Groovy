package groovy;

class Song {
    def name
    def artist
    def genre

    String toString(){
        "${name}, ${artist}, ${genre}"
    }
}