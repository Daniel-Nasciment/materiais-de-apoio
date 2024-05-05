# Design Pattern Adapter em Java


### 1. Introdução:
O Design Pattern Adapter é um padrão de design estrutural que permite que objetos com interfaces incompatíveis trabalhem juntos. Ele atua como uma ponte entre duas interfaces diferentes, permitindo que objetos com interfaces incompatíveis cooperem entre si.

### 2. Exemplo de Código:
Imagine que temos uma biblioteca de reprodução de arquivos de áudio que suporta apenas o formato MP3, mas queremos reproduzir arquivos no formato WAV. Podemos usar o padrão Adapter para adaptar a interface do WAVPlayer para a interface esperada pela biblioteca de reprodução de áudio.

### Interface Esperada pela Biblioteca de Reprodução de Áudio:

```java
// Interface AudioPlayer
interface AudioPlayer {
    void play(String fileName);
}

// Implementação da Biblioteca de Reprodução de Áudio (suporta apenas MP3):

// Implementação concreta de AudioPlayer
class MP3Player implements AudioPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}


// Implementação do Adapter para Reproduzir Arquivos WAV:


// Interface que representa a reprodução de arquivos WAV
interface WAVPlayer {
    void playWAV(String fileName);
}

// Adaptador que converte a interface WAVPlayer para AudioPlayer
class WAVAdapter implements AudioPlayer {
    private WAVPlayer wavPlayer;

    public WAVAdapter(WAVPlayer wavPlayer) {
        this.wavPlayer = wavPlayer;
    }

    @Override
    public void play(String fileName) {
        // Converte a chamada para a interface WAVPlayer
        wavPlayer.playWAV(fileName);
    }
}

// Implementação concreta de WAVPlayer
class SimpleWAVPlayer implements WAVPlayer {
    @Override
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }
}


// Exemplo de Uso:


public class Main {
    public static void main(String[] args) {
        // Criando o player MP3
        AudioPlayer mp3Player = new MP3Player();
        mp3Player.play("song.mp3"); // Saída: Playing MP3 file: song.mp3

        // Adaptando o player WAV para ser compatível com a interface AudioPlayer
        WAVPlayer wavPlayer = new SimpleWAVPlayer();
        AudioPlayer adaptedWAVPlayer = new WAVAdapter(wavPlayer);
        adaptedWAVPlayer.play("song.wav"); // Saída: Playing WAV file: song.wav
    }
}
```
### 3. Observações:
* O padrão Adapter é útil quando você precisa integrar sistemas existentes com interfaces incompatíveis.
* Ele permite que objetos com interfaces diferentes trabalhem juntos sem alterar seu código.
* O Adapter atua como uma camada intermediária que traduz as chamadas de um formato para outro.
Pode ser útil ao utilizar bibliotecas de terceiros ou ao integrar sistemas legados com novos sistemas.
