package com.example.demosharedelement

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
class BlankFragment1 : Fragment() {
    private lateinit var action: View
    private lateinit var translationConstraintLayout: TransitionConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action = view.findViewById(R.id.action_btn)
        translationConstraintLayout = view.findViewById(R.id.screen)
        action.setOnClickListener {
            if (SHARED_TAB_IMAGE == null) {
                val fragmentView = requireView()
                val bitmap = Bitmap.createBitmap(fragmentView.width, fragmentView.height, Bitmap.Config.ARGB_8888)
                val canvas = Canvas(bitmap)
                view.draw(canvas)
                SHARED_TAB_IMAGE = BitmapDrawable(resources, bitmap)
            }

            requireActivity().supportFragmentManager.beginTransaction()
                .addSharedElement(
                    translationConstraintLayout.getSharedImageView(),
                    "shared_tab_name"
                )
                .replace(R.id.container, BlankFragment2())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        var SHARED_TAB_IMAGE: Drawable? = null
    }
}