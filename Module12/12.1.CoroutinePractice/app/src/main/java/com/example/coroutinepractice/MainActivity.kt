package com.example.coroutinepractice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var tv: TextView

    private lateinit var btn2: Button
    private lateinit var tv2: TextView

    private lateinit var btn3: Button
    private lateinit var tv3: TextView

    private lateinit var btn41: Button
    private lateinit var btn42: Button
    private lateinit var tv4: TextView

    private lateinit var btn5: Button
    private lateinit var tv5: TextView

    private lateinit var btn6: Button
    private lateinit var tv6: TextView

    private lateinit var btn7: Button
    private lateinit var tv7: TextView

    private lateinit var btn8: Button
    private lateinit var tv8: TextView

    private lateinit var btn9: Button
    private lateinit var tv9: TextView

    private lateinit var btn10: Button
    private lateinit var tv10: TextView

    private lateinit var btn11: Button
    private lateinit var tv11: TextView


    private val mainScope = CoroutineScope(Dispatchers.Main.immediate)

    private fun errorFlow(): Flow<String> = flow{
        for(n in 1..2) {
            delay(500L)
            emit("OK")
        }
        delay(500L)
        throw Exception("Ошибка!")
    }

    private fun numberFlow(): Flow<Int> = flow{
        for(num in 1..5){
            delay(1000L)
            emit(num)
        }
    }

    private fun number2Flow(): Flow<Int> = flow{
        for(num in 1..100){
            delay(100)
            emit(num)
        }
    }

    private fun string2Flow(): Flow<String> = flow{
        fun genString(): String{
            val genChar = {
                ('a'..'z').random()
            }
            return "${genChar()}${genChar()}${genChar()}${genChar()}"
        }

        for(num in 1..100){
            delay(100)
            emit(genString())
        }
    }

    private fun number3Flow(): Flow<Int> = flow{
        for(num in 1..10){
            delay(300)
            emit(num)
        }
    }

    private fun number4Flow(): Flow<Int> = flow{
        for(num in 1..3){
            delay(1000L)
            emit(num)
        }
    }

    private fun char4Flow(): Flow<Char> = flow{
        for(char in 'A'..'C'){
            delay(1500)
            emit(char)
        }
    }

    private fun namesFlow(): Flow<String> = flow{
        val names = listOf("David", "George", "Lisa", "Matthew", "Lena", "Eugen")
        for(name in names) {
            delay(500)
            emit(name)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn = findViewById(R.id.BTN)
        tv = findViewById(R.id.TV)

        btn2 = findViewById(R.id.BTN2)
        tv2 = findViewById(R.id.TV2)

        btn3 = findViewById(R.id.BTN3)
        tv3 = findViewById(R.id.TV3)

        btn41 = findViewById(R.id.BTN41)
        btn42 = findViewById(R.id.BTN42)
        tv4 = findViewById(R.id.TV4)

        btn5 = findViewById(R.id.BTN5)
        tv5 = findViewById(R.id.TV5)

        btn6 = findViewById(R.id.BTN6)
        tv6 = findViewById(R.id.TV6)

        btn7 = findViewById(R.id.BTN7)
        tv7 = findViewById(R.id.TV7)

        btn8 = findViewById(R.id.BTN8)
        tv8 = findViewById(R.id.TV8)

        btn9 = findViewById(R.id.BTN9)
        tv9 = findViewById(R.id.TV9)

        btn10 = findViewById(R.id.BTN10)
        tv10 = findViewById(R.id.TV10)

        btn11 = findViewById(R.id.BTN11)
        tv11 = findViewById(R.id.TV11)

        var job4: Job? = null

        // Задача: Запуск корутины
        btn.setOnClickListener{
            mainScope.launch {
                delay(3000L)
                tv.text = "Hello, Coroutines"
            }
        }

        // Задача: Несколько корутин (launch vs async)
        btn2.setOnClickListener{
            mainScope.launch{
                val deferredList = listOf(
                    mainScope.async {
                        delay(1000L)
                    },
                    mainScope.async {
                        delay(2000L)
                    }
                )

                deferredList.awaitAll()
                tv2.text = "Обе задачи выполнены"
            }
        }

        // Задача: Переключение контекстов
        btn3.setOnClickListener{
            mainScope.launch {
                withContext(Dispatchers.IO){
                    delay(2000L)
                    withContext(Dispatchers.Main){
                        tv3.text = "Данные загружены"
                    }
                }
            }
        }

        // Задача: Отмена корутины
        btn41.setOnClickListener{
            job4 = mainScope.launch {
                for(number in 0..100){
                    delay(300L)
                    number.toString().also { tv4.text = it }
                }
            }
        }
        btn42.setOnClickListener {
            mainScope.launch {
                job4?.cancelAndJoin()
                tv4.text = getString(R.string.stoppedString)
                delay(3000)
                tv4.text = ""
            }
        }

        // Задача: Обработка ошибок в Flow
        btn5.setOnClickListener{
            mainScope.launch{
                errorFlow()
                    .onEach { tv5.text = "${tv5.text}\n${it}" }
                    .catch{ tv5.text = "${tv5.text}\nОшибка обработана: ${it.message}" }
                    .onCompletion {
                        delay(2000L)
                        tv5.text = ""
                    }
                    .collect{}
            }
        }

        // Задача: Функции потоков (Flow)
        btn6.setOnClickListener {
            mainScope.launch {
                numberFlow()
                    .onEach { tv6.text = "${tv6.text} ${it}" }
                    .onCompletion {
                        delay(2000L)
                        tv6.text = ""
                    }
                    .collect{}
            }
        }


        // Задача: Преобразование данных и объединение потоков
        btn7.setOnClickListener {
            mainScope.launch {
                number2Flow()
                    .combine(string2Flow()){
                        a, b -> "$a - $b"
                    }
                    .onCompletion {
                        delay(3000)
                        tv7.text = ""
                    }
                    .collect{
                        tv7.text = "${tv7.text}\n${it}"
                    }
            }
        }

        // Задача: Фильтрация данных в Flow
        btn8.setOnClickListener {
            mainScope.launch {
                number3Flow()
                    .onCompletion {
                        delay(3000)
                        tv8.text = ""
                    }
                    .filter{ it % 2 == 0}
                    .collect{ tv8.text = "${tv8.text} $it"}
            }
        }

        // Задача: Преобразование потока
        btn9.setOnClickListener {
            mainScope.launch {
                namesFlow()
                    .map { it.uppercase(Locale.ROOT) }
                    .onCompletion {
                        delay(3000)
                        tv9.text = ""
                    }
                    .collect { tv9.text = "${tv9.text}\n$it"}
            }
        }

        // Задача: Буферизация
        btn10.setOnClickListener {
            mainScope.launch {
                numberFlow()
                    .onCompletion {
                        delay(3000L)
                        tv10.text = " "
                    }
                    .collect{
                        delay(500L)
                        tv10.text = "${tv10.text}\n$it"
                    }
            }
        }

        // Задача: Объединение двух потоков
        btn11.setOnClickListener {
            mainScope.launch {
                number4Flow()
                    .buffer()
                    .zip(char4Flow()){ a, b -> "$a - $b"}
                    .onCompletion {
                        delay(3000)
                        tv11.text = ""
                    }
                    .collect{ tv11.text = "${tv11.text}\n$it"}
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}