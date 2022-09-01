package com.tolganacar.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tolganacar.kotlincountries.R
import com.tolganacar.kotlincountries.databinding.FragmentDetailsBinding
import com.tolganacar.kotlincountries.util.downloadFromUrl
import com.tolganacar.kotlincountries.util.placeholderProgressBar
import com.tolganacar.kotlincountries.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.recycler_row.*


class DetailsFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel
    private var countryUuid = 0
    private lateinit var dataBinding : FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = DetailsFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                dataBinding.selectedCountry = country
                /*
                countryNameDetails.text = country.countryName
                countryCapitalDetails.text = country.countryCapital
                countryRegionDetails.text = country.countryRegion
                countryCurrencyDetails.text = country.countryCurrency
                countryLanguageDetails.text = country.countryLanguage
                context?.let {
                    imageViewDetails.downloadFromUrl(country.imageUrl, placeholderProgressBar(it))
                }

                 */
            }
        })
    }

}