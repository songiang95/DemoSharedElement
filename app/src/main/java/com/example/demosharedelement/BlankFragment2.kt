package com.example.demosharedelement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment2 : Fragment() {
    private lateinit var tabImageView : TabImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transition = android.transition.TransitionInflater.from(
            context
        ).inflateTransition(R.transition.image_shared_element_transition)
        sharedElementEnterTransition = ChangeBoundsTransition().apply {
            duration = 2000
        }/*MoveWithScaleAndTranslation().apply {
            duration = 5000
        }*/


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_blank2, container, false)
        tabImageView = view.findViewById(R.id.tab_name)
        tabImageView.setImageDrawable(BlankFragment1.SHARED_TAB_IMAGE)
        return view
    }
}