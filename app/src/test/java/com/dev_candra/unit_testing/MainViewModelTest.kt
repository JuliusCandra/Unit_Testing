package com.dev_candra.unit_testing

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var cuboiModel: CuboiModel

    private val dummyLength = 12.0
    private val dummyWidht = 7.0
    private val dummyHeight = 6.0

    private val dummyVolume = 504.0
    private val dummyCircumference = 100.0
    private val dummySurfaceArea = 396.0

    @Before
    fun before(){
        cuboiModel = mock(CuboiModel::class.java)
        mainViewModel = MainViewModel(cuboiModel)
    }

    @Test
    fun testVolume(){
        cuboiModel = CuboiModel()
        mainViewModel = MainViewModel(cuboiModel)
        mainViewModel.save(dummyWidht,dummyLength,dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume,volume,0.0001)
    }
    
    @Test
    fun testCircumference(){
        cuboiModel = CuboiModel()
        mainViewModel = MainViewModel(cuboiModel)
        mainViewModel.save(dummyWidht,dummyLength,dummyHeight)
        val volume = mainViewModel.getCicumference()
        assertEquals(dummyCircumference,volume,0.0001)
    }

    @Test
    fun testSurfaceArea(){
        cuboiModel = CuboiModel()
        mainViewModel = MainViewModel(cuboiModel)
        mainViewModel.save(dummyWidht,dummyLength,dummyHeight)
        val volume = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea,volume,0.0001)
    }

    @Test
    fun testMockVolume(){
        `when`(mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboiModel).getVolume()
        assertEquals(dummyVolume,volume,0.0001)
    }

    @Test
    fun testMockCircumference(){
        `when`(mainViewModel.getCicumference()).thenReturn(dummyCircumference)
        val circumference = mainViewModel.getCicumference()
        verify(cuboiModel).getCircumference()
        assertEquals(dummyCircumference,circumference,0.0001)
    }
    @Test
    fun testMockSurfaceArea(){
        `when`(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboiModel).getSurfaceArea()
        assertEquals(dummySurfaceArea,surfaceArea,0.0001)
    }


    /*
    kesimpulan
        Junit junit digunakan untuk melakukan unit testing
        Mockito digunakan untuk mock object
        fungsi dari mock object adalah untuk mereplika obyek yang digunakan oleh obyek yang sedang
        ditest
    Manfaat penggunaan dari Mocking
    * Menghindari Terlalu Banyak Depedency
    * Mengurangi kelebihan beban
    * ByPass kendala waktu dalam fungsi

    @Annotation
    @RunWith(MockitoJUnitRunner.class)
    Fungsinya untuk menginisialisai frameworkMockito.
    @Mock
    Fungsinya untuk membuat obyek mock yang akan menggantikan obyek yang asli.
    @Before
    Fungsinya untuk menginisialisasi method sebelum melakukan test
    @Test
    Anotasi ini digunakan pada method yang akan dites.

    Fungsi Test Yang Digunakan
    1. assertEquals
    Fungsi ini merupakan fungsi dari JUnit yang digunakan untuk memvalidasi output yang diharapkan dan output yang sebenarnya.
    2. Verify
    Digunakan untuk memeriksa metode dipanggil dengan arguman yang diberikan. Verify merupkan fungsi dari framework Mockito
    3. any
    Merupakan fungsi dari Mockito yang digunakan untuk mencocokan argumen yang fleksibel. any digunakan bareng dengan verify.
    4. when()
    Digunakan untuk menandakan event di mana Anda ingin memanipulasi behavior dari mock object.
    5. thenReturn()
    Digunakan untuk memanipulasi output dari mock object.
     */

}