package gulfappdevelopment.blogspot.materialtextinputlayout

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.new_dialog.*


/**
 * created by Abdul latheef TK, email:-
 * gulfappdeveloper@gmail.com on 14/07/2020.
 */
class MyDialogFragment : DialogFragment() {
    private val TAG="key"

   var dataTransfer: DataTransfer=object :DataTransfer{
        override fun dataTransfer(s: String) {
           loge(s)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val save = view.findViewById<Button>(R.id.dSaveButton)
        save.setOnClickListener {
            val s=dHeadingText.text.toString().trim()

            dataTransfer.dataTransfer(s)
            dismiss()
        }
    }

    override fun getTheme(): Int {
        return R.style.RoundedCornersDialog
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
       //dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onAttach(context: Context) {
      super.onAttach(context)
        try{
            dataTransfer=context as DataTransfer
        }catch (e:Exception){
            loge(e.toString())
        }

    }


}