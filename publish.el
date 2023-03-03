;; publish.el --- Publish org-mode project on Gitlab Pages
;; Author: Rasmus

;;; Commentary:
;; This script will convert the org-mode files in this directory into
;; html.

(defvar site-attachments
  (regexp-opt '("jpg" "jpeg" "gif" "png" "svg"
                "ico" "cur" "css" "js" "woff" "html" "pdf" "mkv" "mp4"))
  "File types that are published as static fileTest 11s.")

(setq org-babel-default-header-args
      '((:session . "none")
	(:eval . "no")
	(:results . "replace")
	(:exports . "both")
	(:cache . "no")
	(:noweb . "no")
	(:hlines . "no")
	(:tangle . "no")))

(setq org-export-default-language "fr")

(setq org-publish-project-alist
      (list
       (list "site-org"
             :base-directory "."
             :base-extension "org"
             :recursive t
             :publishing-function '(org-html-publish-to-html)
             :publishing-directory "./public"
             :exclude (regexp-opt '("draft"))
             :auto-sitemap t
             :sitemap-filename "index.org"
             :sitemap-file-entry-format "%d *%t* (pdf *%t*)"
             :html-head-extra "<link rel=\"icon\" type=\"image/x-icon\" href=\"/favicon.ico\"/>"
             :sitemap-style 'tree
			 )
	   (list "site-pdf"
             :base-directory "."
             :base-extension "org"
             :recursive t
             :publishing-function '(org-latex-publish-to-pdf)
             :publishing-directory "./public"
             :exclude (regexp-opt '("draft"))
             :auto-sitemap nil
			 )
       (list "site-static"
             :base-directory "."
             :exclude "public/"
             :base-extension site-attachments
             :publishing-directory "./public"
             :publishing-function 'org-publish-attachment
             :recursive t)
	   (list "images"
             :base-directory "images"
             :base-extension (regexp-opt '("jpg" "jpeg" "gif" "png" "svg" "ico"))
             :publishing-directory "./public/images"
             :publishing-function 'org-publish-attachment
             :recursive t)
       (list "videos"
             :base-directory "videos"
             :base-extension (regexp-opt '("mkv" "mp4"))
             :publishing-directory "./public/videos"
             :publishing-function 'org-publish-attachment
             :recursive t)
       (list "site" :components '("site-org") '("site-pdf") '("images") )
	   ))

(provide 'publish)
;;; publish.el ends here
