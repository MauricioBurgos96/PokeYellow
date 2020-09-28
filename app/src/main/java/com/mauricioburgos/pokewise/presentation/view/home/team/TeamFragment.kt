package com.mauricioburgos.pokewise.presentation.view.home.team

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mauricioburgos.pokewise.R
import com.mauricioburgos.pokewise.databinding.PokemonsFragmentBinding
import com.mauricioburgos.pokewise.databinding.TeamFragmentBinding
import com.mauricioburgos.pokewise.presentation.view.adapters.SavedPokemonAdapter
import com.mauricioburgos.pokewise.presentation.view.home.HomeActivity
import com.mauricioburgos.pokewise.presentation.viewmodel.PokemonTeamViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFragment() : Fragment() {
    private val adapter = SavedPokemonAdapter(mutableListOf())
    lateinit var binding: TeamFragmentBinding
    private val pokemonTeamViewModel: PokemonTeamViewModel by lazy {
        ViewModelProvider(this@TeamFragment).get(PokemonTeamViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // AppController.component.inject(this)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater, R.layout.team_fragment, container, false)

        (activity as HomeActivity).changeToolbarText(getString(R.string.my_team))

        observePokemonsSaved()
        binding.typesRecyclerView.adapter = adapter


        return binding.root
    }



    override fun onResume() {
        super.onResume()

    }


    private fun observePokemonsSaved (){
        pokemonTeamViewModel.getAllPokemons().observe(viewLifecycleOwner, Observer { pokemons ->
            //Toast.makeText(context, "Tienes ${pokemons.size.toString()} pokemons guardados.", Toast.LENGTH_SHORT).show()
            if(pokemons.isEmpty()){
                binding.placeholderLayout.visibility = View.VISIBLE

            }
            else{
                binding.placeholderLayout.visibility = View.INVISIBLE

            }
            adapter.setData(pokemons)

        })

    }



}


