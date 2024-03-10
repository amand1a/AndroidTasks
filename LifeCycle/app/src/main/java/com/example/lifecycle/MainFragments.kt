package com.example.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.lifecycle.databinding.MainFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainFragments : Fragment(R.layout.main_fragment)  ,NoticeDialogFragment.NoticeDialogListener {
    lateinit var binding: MainFragmentBinding
    var cornedRadius = 0f
    var totalTimeInBackground = System.currentTimeMillis()
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,  savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        init()
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            updateUi( read(key) ?: 0f)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentLifecycle" , "onCreate ${savedInstanceState}")
        if (savedInstanceState == null) {
            Log.d("FragmentLifecycle" , "null")
        }
        if (savedInstanceState != null) {
            cornedRadius = savedInstanceState.getFloat("cornerRadius")
        }





    }

    private suspend fun save(key: String  , radius: Float  ){
        val dataStoreKey  = floatPreferencesKey(key)
        context?.dataStore?.edit {
            it[dataStoreKey] = radius
        }
        Log.d("FragmentLifecycle" , "data is save")
    }



    private suspend fun read(key: String): Float?{
        val dataStoreKey = floatPreferencesKey(key)
        val preferences =   context?.dataStore?.data?.first()
        return preferences?.get(dataStoreKey)
    }

    fun init(){
        binding.apply {
            button.setOnClickListener{
                NoticeDialogFragment().show(childFragmentManager  , "NoticeFragment")
            }
        }

        updateUi(cornedRadius)

    }

    fun updateUi(radius: Float){
        cornedRadius += radius
        binding.cardView.radius = cornedRadius
        binding.textView.text = cornedRadius.toString()
    }



    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following
    // methods defined by the NoticeDialogFragment.NoticeDialogListener
    // interface.
    override fun onDialogPositiveClick(dialog: DialogFragment) {
        updateUi(10f)
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        // User taps the dialog's negative button.
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putFloat("cornerRadius", binding.cardView.radius)
        Log.d("FragmentLifecycle" , "onSaveInstanceState ${cornedRadius.toString() }  ${outState}")
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {

            save(key, cornedRadius)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentLifecycle", "onAttach")
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("FragmentLifecycle", "onCreateView")
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onStart() {
        super.onStart()
        Log.d("FragmentLifecycle", "onStart")
        updateUi(2f)
        val timeSpentInBackground = System.currentTimeMillis() - totalTimeInBackground
        Log.d("FragmentLifecycle", timeSpentInBackground.toString())
        val minutesInBackground = timeSpentInBackground / (1000 * 60)
        // Уменьшить cornerRadius на 2 за каждую минуту, проведенную в свернутом состоянии

        Log.d("FragmentLifecycle", minutesInBackground.toString())
        updateUi(-((minutesInBackground*2).toFloat()))
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentLifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentLifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentLifecycle", "onStop")
        cornedRadius += 5
        totalTimeInBackground = System.currentTimeMillis()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentLifecycle", "onDestroyView")


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentLifecycle", "onDestroy")
        // Добавьте здесь код для проверки значений cornerRadius и totalTimeInBackground
        // и выполните необходимые действия
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentLifecycle", "onDetach")
        // Добавьте здесь код для проверки значений cornerRadius и totalTimeInBackground
        // и выполните необходимые действия
    }


    companion object{
        const val key = "key"
    }
}